package com.dp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class P19CountingSundays
{
    LocalDate firstSunday = LocalDate.of(1900, 1, 7);

    interface days
    {
        default int numOfDays(int year) {return 31;}
    }

    enum Month
            implements days
    {

        January(1),

        February(2) {
            @Override
            public int numOfDays(int year)
            {
                if (year % 400 == 0) { return 29; }
                if (year % 100 == 0) { return 28; }
                if (year % 4 == 0) { return 29; }
                return 28;
            }
        }, March(3), May(5), July(7), August(8), October(10), December(12),

        September(9) {
            @Override
            public int numOfDays(int year) {return 30;}
        },
        April(4) {
            @Override
            public int numOfDays(int year) {return 30;}
        },
        June(6) {
            @Override
            public int numOfDays(int year) {return 30;}
        },
        November(11) {
            @Override
            public int numOfDays(int year) {return 30;}
        };

        int index;

        Month(int index)
        {
            this.index = index;
        }

        static List<Month> getMonths()
        {
            return Arrays.asList(January, February, March, April, May, June, July, August, September, October, November, December);
        }

        public static Month valueOf(int value)
        {
            return getMonths().stream().filter(m -> m.index == value).findFirst().orElseThrow(IllegalArgumentException::new);
        }

        public Month nextMonth()
        {
            Iterator<Month> iterator = getMonths().iterator();
            while (iterator.hasNext()) {
                Month current = iterator.next();
                if (current.equals(this)) {
                    if (iterator.hasNext()) {
                        return iterator.next();
                    }
                    else {
                        return January;
                    }
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args)
    {
        P19CountingSundays p19CountingSundays = new P19CountingSundays();
        int result = p19CountingSundays.count(LocalDate.of(1901, 1, 1), LocalDate.of(2000, 12, 31));
        System.out.printf("total number of sundays was:%d%n", result);
    }

    private int count(LocalDate from, LocalDate to)
    {
        int currentYear = firstSunday.getYear();
        Month currentMonth = Month.valueOf(firstSunday.getMonth().getValue());
        int sundaysCount = 0;
        int days = firstSunday.getDayOfMonth();
        for (; isEndOfPeriod(to, currentYear, currentMonth, days); days += 7) {
            if (days > currentMonth.numOfDays(currentYear)) {
                days %= currentMonth.numOfDays(currentYear);
                currentMonth = currentMonth.nextMonth();

                if (currentMonth.equals(Month.January)) { currentYear++; }
            }

            verifySunday(currentYear, currentMonth, days);

            if (isInRequestedPeriod(currentYear, currentMonth, days, from) && getCurrentDay(currentYear, currentMonth, days) == 1) {
                System.out.printf("Sunday %d/%d/%d%n", currentYear, currentMonth.index, getCurrentDay(currentYear, currentMonth, days));
                sundaysCount++;
            }else{
                System.out.printf("Skipping - Sunday %d/%d/%d%n", currentYear, currentMonth.index, getCurrentDay(currentYear, currentMonth, days));
            }
        }

        return sundaysCount;
    }

    private void verifySunday(int currentYear, Month currentMonth, int days)
    {
        if (!DayOfWeek.SUNDAY.equals(LocalDate.of(currentYear, currentMonth.index, getCurrentDay(currentYear, currentMonth, days)).getDayOfWeek())) {
            throw new RuntimeException();
        }
    }

    private boolean isInRequestedPeriod(int currentYear, Month currentMonth, int days, LocalDate from)
    {
        return ( currentYear >= from.getYear() && currentMonth.index >= from.getMonth().getValue() && getCurrentDay(currentYear, currentMonth, days) >= from.getDayOfMonth());
    }

    private int getCurrentDay(int currentYear, Month currentMonth, int days)
    {
        if ( days % currentMonth.numOfDays(currentYear) == 0)
            return days;
        return days % currentMonth.numOfDays(currentYear);
    }

    private boolean isEndOfPeriod(LocalDate to, int currentYear, Month currentMonth, int days)
    {
        return currentYear <= to.getYear() && currentMonth.index <= to.getMonthValue() && (days % currentMonth.numOfDays(currentYear) <= to.getDayOfMonth());
    }
}
