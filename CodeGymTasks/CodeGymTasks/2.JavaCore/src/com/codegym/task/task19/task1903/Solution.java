package com.codegym.task.task19.task1903;

/* 
Adapting multiple interfaces

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR", "France");
    }


    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryCode = data.getCountryCode();
            String country = "Unknown";

            for (Map.Entry<String, String> map: countries.entrySet()) {
                if (map.getKey().equals(countryCode)) {
                    country = map.getValue();
                    break;
                }
            }
            return country;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            String num = Integer.toString(data.getPhoneNumber());

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 10 - num.length(); i++) {
                builder.append("0");
            }

            builder.append(num);
            num = builder.toString();

            return "+" + data.getCountryPhoneCode() + "(" + num.substring(0, 3)
                    + ")" + num.substring(3, 6) + "-" + num.substring(6, 8)
                    + "-" + num.substring(8, 10);
        }
    }


    /**
     * IncomeData interface
     */
    public static interface IncomeData {
        String getCountryCode();        // For example: US

        String getCompany();            // For example: CodeGym Ltd.

        String getContactFirstName();   // For example: John

        String getContactLastName();    // For example: Smith

        int getCountryPhoneCode();      // For example: 1

        int getPhoneNumber();           // For example: 991234567
    }

    /**
     * Customer interface
     */
    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.

        String getCountryName();        // For example: United States
    }

    /**
     * Contact interface
     */
    public static interface Contact {
        String getName();               // For example: Smith, John

        String getPhoneNumber();        // For example: +1(099)123-45-67
    }
}