
Java Training

Banuprakash C

Co-Founder, Lucida Technologies Pvt Ltd.

Full Stack Architect

banuprakashc@yahoo.co.in

banu@lucidatechnologies.com

GITHub: https://github.com/BanuPrakash/cisco_java

=======================================

Softwares Required:
1) JDK 8:
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
2) Eclipse IDE for Enterprise Java Developers
	https://www.eclipse.org/downloads/packages/release/2020-03/r
3) MySQL Community Server 5.7.29 version
	https://downloads.mysql.com/archives/community/

======================================================================
	OOP ==> Object Oriented Programming

	Programming which resemble real world application.

	everything is an object. Laptop, TV, Chair, AC, Fan, ....

	objects communicate with other object by sending a message.

	I am an object, I send a message on/off to a bulb using it's interface [switch]

	send change channel, incr/dec sound of TV using Remote interface

	Interface exposes what all messages an object can understand.
	If other objects has to communicate with an given object, he needs to understand 
	what each message in the interface does.
	You don't need to understand how the message works, but just need to know what it does.


	Design principles which you need to follow builing an OOP:

	SOLID design principle:
		S ---> Single Responsibilty
			Any object --> a single responsibility
			bulb --> illumination
			AC --> regulate temperature

		Input/message  -->  	Object 	--> output

		O --> Open Close Principle
			Objects/Components should be closed for a change, but open for extension.

		L --> Liskov Substitution Principle	

				At any point specialized objects can be used to get the tasks done
				by generalized

				Specialized can substitute Generalized one
		I --> interface segregation
				Account object
					Customer Interface
						transaction
						check balance
						check my transactions
					Manager Interface
						create account
						suspend account
						check all transactions
					Teller Interface
		D --> Depedency Injection ==> Inversion Of Control
	=======================================================================================

	Objects will have state and behaviour
		A/C --> temperature is the state
				state of object should be changed by certain actions/behaviour
					increaseTemp()
					decreaseTemp()


		Account --> balance is the state
					credit()
					debit()

		Never change the state directly, always change it thor invoking actions/behaviour/methods/functions

		state is not exposed outside of the object [ private visibility]


			Account: balance --> 5000

				account.balance += 3000; // error

				account.credit(3000); // valid

	==============

		To create an object we need a template/blue print
			Different programming languages uses different ways of creating a template.

			Example:
				function is a template in JavaScript
				class is a template used by C++ / C# and Java
				Type is a template used by Oracle

			JS:
				function Account() {
						//
				}	

				let a = new Account(); // a is an object of type Account, a is an instance of Account

			Java:
				class Account {

				}

				Account a = new Account(); // a is an instance of Account, object of Account

	========================================================================================
		C is self-contained
			compile + link ==> exe
			This exe is self contained, it just needs  OS to execute

		Java
			Java is a Technology
			==> Java technology provides a platform
						==> environment to execute bytecode [ compiled code]
						==> APIs
				bytecode is not self-contained,
				to execute this bytecode, platform should provide additional APIs

			How to generate bytecode?

			Source Code   								---> Compiler    		----> Bytecode
		  	code in Java language 							javac 						compiled code
		  	code in Kotlin language 						Kotlin Compiler 			compiled code


		  	In a team, each module could use different programming laguages 


		 source --> Compiler --> bytecode	

		 JDK -==> Java Development Kit
		 KOtlin Development Kit
	==============================================================================

	Eclipse IDE
		==> Workspace ==> place where projects reside

		javac 		FirstExample.java  ===> FirstExample.class [ bytecode]

		java FirstExample [ executes FirstExample.class]

	=============================================================================

	C code is not portable , beacuse we have an exe created which will link to native libariry

	Java ==> Bytecode is portable, bytecode created on Mac can be taken to windows or SetTopBox , or any other device

	========================================================================
 

	Grouping objects logically :
		a) entity 
			business data: data which survives beyond the life of application. they would be persited
			Uber:
				Customer, Vehicle, Driver, Trip, Payment
			Amazon:
				Customer, Product, Order, Supplier, Delivery, Payment

			These classes are the easy to create.

			They contain "constructor", "setters" , "getters", "equals" methods

			Mutation is done using setters:
				setPassword(pwd);
			Accessor
				getPassword()

			p1.equals(p2); 

			Avoid business logic in entity class

		b) DAO [ Data Access Object]
			Code to Perform CRUD operations.
			CREATE READ UPDATE DELETE
			if persistence is in RDBMS, CRUD will be done thro SQL
			"select * from ..."
			"insert into ...."

		c) Business
				business logic

		d) Service
				Facade on Business and DAO operations.
				Generally it combines many fine grained operations into coarse grained operations
				and makes it atomic

				// Transactional
				public void transferFunds(Account from, Account to , double amt) {
						DAO methods:
							a) select balance from "from account", check if sufficient balance
							b) send to business logic and check if eligible to transfer
							c) update "from" account
							d) update "to" account
							e) "insert" into tranascation table
							f) send SMS
				}

		e) Utility
			helpers
				sort, dateconversion, currency format
		f) Exception
			to represent abnormal conditions
		g) UI/ Client 
			Web, Mobile, Standalone

			====================================

			In Java we use "packages" to group logical classes
			packages ==> folders
			without packages codes are not re-usable

			Conventions used to create a package:

			com.cisco.hathway.entity
				Customer.java
				Channel.java

			com.cisco.hathway.dao

			com.cisco.hathway.service
				CustomerService.java

			internally packages creates folders
				com
					|
					cisco
						|
						hathway
							|
							entity
								Customer.class
								Channel.class
							|
							service
								CustomerService.class



		In OOP we invoke methods using context:

			bulbOne.on();

			bulbTwo.off();


		rahulAcc.deposit(5400);

		context is "rahulAcc", action is "deposit"

		rahulAcc.deposit(5400); ===> deposit(rahulAcc, 5400); 
		swethaAcc.deposit(3000); ==> deposit(swethaAcc, 3000);

		public void deposit(double amt) {
			balance += amt;
		}

		gets converted to:
		public void deposit(Account this, double amt) {
			this.balance += amt;
		}

		=== 

		Step Filters will help while debug

			Cursor ==> System.out.println();

				Step In accendentally

		===================================================

		Constructors are invoked when objects are created.

		class Account {

				deposit()
				getBalance();
		}

		Compiler introduces a constructor

		class Account {
				// default
				public Account() {
					// code gets executed once when object is created
					// called when you invoke new Account()
					// init code comes here
				}

				// parametrized
				public Account(double amt) {
					this.balance += amt;
					// new Account(5000);
				}

				void deposit()
				double getBalance()
		}


		Primitive types:

		int x = 10;
		int y = 10;

		x == y; // true

		Objects:
		Account a = new Account("SB123");
		Account b = new Account("SB123");
		Account c = a;

		a == b; // checks the reference ==> false

		c == a; // true
		
		==========

		== vs equals()

		== is used to compare reference / address location

		equals() is used to compare state / values

		a.equals(b); // should evaluate to true

		Object.java
		 public boolean equals(Object obj) {
     	   return (this == obj);
    	}



    	class Rectangle {
    			int width, breadth

    			public boolean equals(Object obj) {
    					Rectangle other = (Rectangle) obj;
    					if( this.width == other.width && this.height == other.height) {
    						return true;
    					}
    					return false;
    			}
    	}



    	=============

    	instance variable are created for every object on heap area.

    	instance methods are invoked using a context

    	a.deposit(45000);

    	a.getBalance();

    	constructors();// intialization

    	== vs equals()
    	===============================

    	Need to track how many account instances are created
================================================================================

	JVM => Class Data , Stack and Heap

	Local variables reside on Stack [ method level]
	instance variables reside on HEAP [ object specific members]
	static variables is in class data. [ shared by all objects of a class]

	in Java we don't have global variables
=================================================================================

	Relationship between objects:
		a) Generalization and Specialization
		b) Realization
		c) Association
		d) Uses A Relationship
		============

		Generalization and Specialization done using Inheritance in programming language

	Java Development Tools:
		1) IDE --> Eclipse, IntelliJ, NetBeans,..
		2) Maven --> Depdendency Management Tool
		3) CheckStyle
			--> static code analysis
			Checks Naming Conventions of Class , variable, package and methods
			Java uses CamelCase for Class, var and methods

			class OracleConnection {}
			getMeTea() {}
			int userAge;

			Java uses Snake case for constants and only upper case characters
			final int MAX_AGE = 100;
		4) PMD / FindBugs
			--> static code analysis to check good programming concepts

			a) Code Not reachable
			b) Empty conditional statement
				if(conditon) {

				} else {
						code
				}
			c) Empty catch blocks
			d) Copy and Paste Code
				setId() getId() setName() getName() present in both Mobile and Tv
				recommends to apply DRY principle ==> Don't Repeat Yourself == >Reuse

		==========================

		TataSky Adv [https://www.youtube.com/watch?v=hXkzfLaps8s]

			1) Lady goes to a Tailor [ Tom Alter]
			2) Tailor asks what do you keep in your pocket?
			3) Lady replies ==> Whatever, TV 

			4) Tailor says "i need to stich 14 inch or 32 inch pocket"

			Problem: Wrong relation 

			She meant "Mobile which has TataSky Tv app" <-- Has A
				"Mobile is a Tv" < -- IS A
		================================

		How to establish IS-A Relationship [ Generalization and Specialization ] in Java

		==> keyword [ extends]

		// implicitly Product extends Object
		class Product  {

		}
		// Mobile is a specialized Product
		class Mobile extends Product {

		}


		class Tv extends Product {

		}

		In Java Object is the root class for every object

		=========================================================

		1) 
		public class Product  {
			public Product() {
				s.o.p("P1");
			}
			public Product(int id) {
				s.o.p("P2");
			}
		}
		 
		public class Mobile extends Product {
			public Mobile() {
				s.o.p("M1");
			}
			public Mobile(int id, String connectivity) {
				s.o.p("M2");
			}
		}


		Mobile m = new Mobile(); // P1, M1


		===========

		2) 
		public class Product  {
			public Product() {
				s.o.p("P1");
			}
			public Product(int id) {
				s.o.p("P2");
			}
		}
		 
		public class Mobile extends Product {
			public Mobile() {
				s.o.p("M1");
			}
			public Mobile(int id, String connectivity) {
				s.o.p("M2");
			}
		}


		Mobile m = new Mobile(100, "iPhone XR"); // P1, M2


		3) 
	
		public class Product  {
			public Product() {
				s.o.p("P1");
			}
			public Product(int id) {
				s.o.p("P2");
			}
		}
		 
		public class Mobile extends Product {
			public Mobile() {
				s.o.p("M1");
			}
			public Mobile(int id, String connectivity) {
				super(id);
				s.o.p("M2");
			}
		}


		Mobile m = new Mobile(100, "iPhone XR"); // 




		===
		Don't do this:
			public Mobile(int id, String connectivity) {
			
				s.o.p("M2");
				super(id); // ERROR
			}

			Compiler adds super();

			public Mobile(int id, String connectivity) {
				super();
				s.o.p("M2");
				super(id); // ERROR
			}

		===================================================

		Inheritance and methods:

		class Product  {
			public double getPrice() {
					return 100;
			}
		}
		 
		class Mobile extends Product {
			@Override
			public double getPrice() {
					return 500;
			}

			public String getConnectivity() {
				return "4G";
			}
		}

		Mobile m = new Mobile();
		m.getPrice() ; // 500
		m.getConnectivity(); // 4G

		override is a conspt where a base class already has that functionality,
		but we supress and override by redefining in inherited class

		// create an object of mobile, but use product pointer/ref
		Product p = new Mobile(); // valid ==> upcasting

		s.o.p(p.getPrice()); // 500
		s.o.p(p.getConnectivity()); // Product doesn't understand getConnectivity() == Compilation ERROR
=========================================================================================================
	

	Dishwasher, Washin Machine, Microwave, .....
	Product[] products = new Product[5000]; 
		can have tv. mobile, wm.mw, ....


	private static void displayExpensive(Product[] products) {
		for(Product p : products) {
			if(p.isExpensive()) {
				System.out.println(p.getName() + " is expensive !!!");
			} else {
				System.out.println(p.getName() + " is not expensive !!!");
			}
		}
	}

	Without upcasting:
		Mobile[] ..
		Tv[] ...

		for(Mobile m : mobiles){

		}
		for(Tv t : tvs){

		}

		for(Wm wm : machines) {

		}


	Product p = new Tv();

	(p instanceof Tv) ==> true

	(p instanceof Product) ==> true

	(p instanceof Object) ==> true

	(p instanceof Mobile) ==> false



	(p.getClass() == Tv.class) ==> true
	(p.getClass() == Product.class) ==> false
	(p.getClass() == Object.class) ==> false
	=========================

	3 days
		OOP, collection, Java 8 features, Threads, Functional Style
	4 and 5 day
		JDBC, Web application , RESTful web services