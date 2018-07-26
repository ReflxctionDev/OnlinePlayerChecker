/*
 * * Copyright 2017-2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.opc.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 * Contains various helpful methods for strings
 */
class StringUtils {

    /**
     * A human readible text of the date, e.g "11th of June, 2016"
     *
     * @param date Date to convert
     * @return Text of the date
     */
    static String convertDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        Month month = Month.of(localDate.getMonthValue());
        int day = localDate.getDayOfMonth();
        return appendNumber(day) + " of " + capitalize(month.name()) + ", " + year;
    }

    /**
     * Capitalizes a string
     *
     * @param text String to capitalize
     * @return The capitalized string
     */
    private static String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    /**
     * Appends the letters near a number in day values, e.g "1st", "2nd", etc.
     *
     * @param day Day to append for
     * @return The day value with the letters.
     */
    private static String appendNumber(int day) {
        String n = Integer.toString(day);
        switch (n) {
            case "1":
                n = "1st";
                break;
            case "21":
                n = "21st";
                break;
            case "2":
                n = "2nd";
                break;
            case "22":
                n = "22nd";
                break;
            case "3":
                n = "3rd";
                break;
            case "23":
                n = "23rd";
                break;
            default:
                n = n + "th";
                break;
        }
        return n;
    }

}
