package com.dp.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
	char[][] _board = null;
	List<String> _result = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {

		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;

			for (Character letter : word.toCharArray()) {
				if (!node.children.containsKey(letter)) {
					node.children.put(letter, new TrieNode());
				}
				node = node.children.get(letter);
			}
			node.word = word;  // store words in Trie
		}

		this._board = board;
		// Step 2). Backtracking starting for each cell in the board
		for (int row = 0; row < board.length; ++row) {
			for (int col = 0; col < board[row].length; ++col) {
				if (root.children.containsKey(board[row][col])) {
					backtracking(row, col, root);
				}
			}
		}

		return _result;
	}

	enum Offset {
		LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1);

		Offset(int row, int col) {
			this.row = row;
			this.col = col;
		}

		int row;
		int col;
	}

	private void backtracking(int row, int col, TrieNode parent) {
		Character letter = this._board[row][col];
		TrieNode currNode = parent.children.get(letter);

		// check if there is any match
		if (currNode.word != null) {
			this._result.add(currNode.word);
			currNode.word = null;
		}

		// mark the current letter before the EXPLORATION
		this._board[row][col] = '#';

		// explore neighbor cells in around-clock directions: up, right, down, left
		for (Offset offset : Offset.values()) {
			int newRow = row + offset.row;
			int newCol = col + offset.col;
			if (newRow < 0 || newRow >= this._board.length || newCol < 0
					|| newCol >= this._board[0].length) {
				continue;
			}
			if (currNode.children.containsKey(this._board[newRow][newCol])) {
				backtracking(newRow, newCol, currNode);
			}
		}

		// End of EXPLORATION, restore the original letter in the board.
		this._board[row][col] = letter;

		// Optimization: incrementally remove the leaf nodes
		if (currNode.children.isEmpty()) {
			parent.children.remove(letter);
		}
	}

	class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		String word = null;
	}
}
