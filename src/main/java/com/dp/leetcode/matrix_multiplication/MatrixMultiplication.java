package com.dp.leetcode.matrix_multiplication;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

import scala.Function1;
import scala.Serializable;
import scala.Tuple2;
import static org.apache.spark.sql.functions.col;

public class MatrixMultiplication {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder()
				.appName("matrix_multiplication")
				.master("local").getOrCreate();

		spark.sparkContext().setLogLevel("ERROR");

		List<Cell> dataA = new ArrayList<>();
		dataA.add(new Cell(1, 1, 3));
		dataA.add(new Cell(1, 2, 4));
		dataA.add(new Cell(2, 1, 2));
		dataA.add(new Cell(2, 2, 1));

		List<Cell> dataB = new ArrayList<>();
		dataB.add(new Cell(1, 1, 1));
		dataB.add(new Cell(1, 2, 5));
		dataB.add(new Cell(2, 1, 3));
		dataB.add(new Cell(2, 2, 7));

		Dataset<Row> dsA = spark.createDataFrame(dataA, Cell.class);
		Dataset<Row> dsB = spark.createDataFrame(dataB, Cell.class);

		JavaPairRDD<String, Row> a = dsA.toJavaRDD().mapToPair((PairFunction<Row, String, Row>) row -> Tuple2.apply(row.getString(0), row));
		JavaPairRDD<String, Row> b = dsB.toJavaRDD().mapToPair((PairFunction<Row, String, Row>) row -> Tuple2.apply(row.getString(0), row));
		a.join(b).map(new Function<Tuple2<String, Tuple2<Row, Row>>, Object>() {
			@Override public Object call(Tuple2<String, Tuple2<Row, Row>> stringTuple2Tuple2) throws Exception {
				return null;
			}
		});

		Dataset<Row> result = dsA.join(dsB, dsA.col("col").equalTo(dsB.col("row")))
				.groupBy(dsA.col("row"), dsB.col("col"))
				.agg(functions.sum(dsA.col("value").multiply(dsB.col("value"))).alias("product"))
				.select(col("row"), col("col"), col("product"));
		result.show();
	}

	public static class Cell implements Serializable {
		int row;
		int col;
		int value;

		public Cell(int row,
				int col,
				int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		@Override public String toString() {
			return "Cell{" +
					"row=" + row +
					", col=" + col +
					", value=" + value +
					'}';
		}
	}
}
