/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package kiranaStore.InventoryManagement;
import kiranaStore.InventoryManagement.dto.*;
import java.io.*;
public class SimpleService {
	public static void main(String args[]) throws Exception{
		Test test=new Test();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Add Customer\n2.Display Customer by id\n3.Display list of all customers");
		System.out.println("\n4.Add Employee\n5.Display Employee by id\n6.Display list of all employees");
		System.out.println("\n7.Add Product\n8.Display Product by id\n9.Display list of all products");
		System.out.println("\n10.Add Order\n11.Display order by id\n12.Display all the orders");
		System.out.println("Enter your choice:");
		int n=Integer.parseInt(br.readLine());
		switch(n) {
		case 1:
			Customer c=new Customer();
			System.out.println("Enter the details to be added to the Customer database:(id,name,phone,age):");
			System.out.println("Enter id:");
			c.setCustomerId(Integer.parseInt(br.readLine()));
			System.out.println("Enter name:");
			c.setCustomerName(br.readLine());
			System.out.println("Enter Phone:");
			c.setCustomerPhone(br.readLine());
			System.out.println("Enter age:");
			c.setCustomerAge(Integer.parseInt(br.readLine()));
			test.addCustomer(c);
			System.out.println("Customer Added successFully!!\n");
			break;
		case 2:
			System.out.println("Enter the CustomerId you want to search:");
			int k=Integer.parseInt(br.readLine());
			test.display(k);
			break;
		case 3:
			System.out.println("The Customers are as follows\n");
			test.displayCustomers();
			break;
		case 4:
			Employee e=new Employee();
			System.out.println("Enter the details to be added to employee:");
			System.out.println("Enter id");
			e.setEmployeeId(Integer.parseInt(br.readLine()));
			System.out.println("Enter the name");
			e.setEmployeeName(br.readLine());
			System.out.println("Enter salary");
			e.setSalary(Integer.parseInt(br.readLine()));
			System.out.println("Enter Job Title");
			e.setJobTitle(br.readLine());
			test.addEmployee(e);
			System.out.println("Employee Added successFully");
			break;
		case 5:
			System.out.println("Enter the EmployeeId you want to search:");
			int k1=Integer.parseInt(br.readLine());
			test.displayEmployee(k1);
			break;
		case 6:
			System.out.println("The Employees are as follows\n");
			test.displayEmployees();
			break;
		case 7:
			Product p=new Product();
			System.out.println("Enter Product id");
			p.setProductId(Integer.parseInt(br.readLine()));
			System.out.println("Enter the product name:");
			p.setProductName(br.readLine());
			System.out.println("Enter the product price");
			p.setProductPrice(Integer.parseInt(br.readLine()));
			System.out.println("Enter the product availability");
			p.setProductAvailability(Integer.parseInt(br.readLine()));
			test.addProduct(p);
			System.out.println("Product added successfully");
			break;
		case 8:
			System.out.println("Enter the ProductId you want to search:");
			int k2=Integer.parseInt(br.readLine());
			test.displayProduct(k2);
			break;
		case 9:
			System.out.println("Products are as follows:\n");
			test.displayProducts();
			break;
		case 10:
			System.out.println("Enter Order id");
			int oid=Integer.parseInt(br.readLine());
			System.out.println("Enter ProductId");
			int pid=Integer.parseInt(br.readLine());
			System.out.println("Enter Customerid");
			int cid=Integer.parseInt(br.readLine());
			System.out.println("Enter Product Quantity");
			int pqty=Integer.parseInt(br.readLine());
			test.addOrder(oid,pid,cid,pqty);
			//test.addOrder();
			System.out.println("Order added successfully");
			break;
		case 11:
			System.out.println("Enter the OrderId you want to be searched:");
			int orderId=Integer.parseInt(br.readLine());
			test.displayOrder(orderId);
			break;
		case 12:
			System.out.println("Orders are as follows:\n");
			test.displayOrders();
			//test.displayTotal();
			break;
			
		default:
			System.out.println("Invalid choice");
			break;
		}
		}
		
	}


