package com.cts.revenueforecast.model;

import java.util.List;

public class VacationDetails {
		private String employee_id, name, email, pto_jan, pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec;

		public String getEmployee_id() {
			return employee_id;
		}

		public void setEmployee_id(String employee_id) {
			this.employee_id = employee_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPto_jan() {
			return pto_jan;
		}

		public void setPto_jan(String pto_jan) {
			this.pto_jan = pto_jan;
		}

		public String getPto_feb() {
			return pto_feb;
		}

		public void setPto_feb(String pto_feb) {
			this.pto_feb = pto_feb;
		}

		public String getPto_mar() {
			return pto_mar;
		}

		public void setPto_mar(String pto_mar) {
			this.pto_mar = pto_mar;
		}

		public String getPto_apr() {
			return pto_apr;
		}

		public void setPto_apr(String pto_apr) {
			this.pto_apr = pto_apr;
		}

		public String getPto_may() {
			return pto_may;
		}

		public void setPto_may(String pto_may) {
			this.pto_may = pto_may;
		}

		public String getPto_june() {
			return pto_june;
		}

		public void setPto_june(String pto_june) {
			this.pto_june = pto_june;
		}

		public String getPto_july() {
			return pto_july;
		}

		public void setPto_july(String pto_july) {
			this.pto_july = pto_july;
		}

		public String getPto_aug() {
			return pto_aug;
		}

		public void setPto_aug(String pto_aug) {
			this.pto_aug = pto_aug;
		}

		public String getPto_sept() {
			return pto_sept;
		}

		public void setPto_sept(String pto_sept) {
			this.pto_sept = pto_sept;
		}

		public String getPto_oct() {
			return pto_oct;
		}

		public void setPto_oct(String pto_oct) {
			this.pto_oct = pto_oct;
		}

		public String getPto_nov() {
			return pto_nov;
		}

		public void setPto_nov(String pto_nov) {
			this.pto_nov = pto_nov;
		}

		public String getPto_dec() {
			return pto_dec;
		}

		public void setPto_dec(String pto_dec) {
			this.pto_dec = pto_dec;
		}

		public VacationDetails(String employee_id, String name, String email, String pto_jan, String pto_feb,
				String pto_mar, String pto_apr, String pto_may, String pto_june, String pto_july, String pto_aug,
				String pto_sept, String pto_oct, String pto_nov, String pto_dec) {
			super();
			this.employee_id = employee_id;
			this.name = name;
			this.email = email;
			this.pto_jan = pto_jan;
			this.pto_feb = pto_feb;
			this.pto_mar = pto_mar;
			this.pto_apr = pto_apr;
			this.pto_may = pto_may;
			this.pto_june = pto_june;
			this.pto_july = pto_july;
			this.pto_aug = pto_aug;
			this.pto_sept = pto_sept;
			this.pto_oct = pto_oct;
			this.pto_nov = pto_nov;
			this.pto_dec = pto_dec;
		}

		public VacationDetails() {
			super();
		}
		
		public VacationDetails(List<String> vl){
			this.employee_id = vl.get(0);
			this.name = vl.get(1);
			this.email = vl.get(2);
			this.pto_jan = vl.get(3);
			this.pto_feb = vl.get(4);
			this.pto_mar = vl.get(5);
			this.pto_apr = vl.get(6);
			this.pto_may = vl.get(7);
			this.pto_june = vl.get(8);
			this.pto_july = vl.get(9);
			this.pto_aug = vl.get(10);
			this.pto_sept = vl.get(11);
			this.pto_oct = vl.get(12);
			this.pto_nov = vl.get(13);
			this.pto_dec = vl.get(14);
		}
		public Object[] getObjectArray() {
			return new Object[]{employee_id, name, email, pto_jan, pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec}; 
		}
}
