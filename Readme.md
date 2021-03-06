
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
		============

		Day 2
		======
		ctrl + space
			syso
			for
			foreach
==================================================================

		Array's are reference type in Java
			Memory is allocated on heap area and it's pointer/reference is on stack

		int[] elems = new int[4];

		int[] data = {45,122,6,15};

		In Java we don't have pointer arithmetics

		In c or c++:
		int * ptr = ..
		ptr++;
		ptr++;

		=====================

		rahulAcc ID 	17
		swethaAcc ID 	21


		In Programming languages which uses Virtual Machine [ Java, .NET, JS], address locations are 
		never exposed directly 

		Why this approach?
			All codes which run on VMs [ Java VM] uses GC ==> Garbage Collection.

			GC is a thread running within VM whose job is to remove un reachable objects.

		--

		In C:
			int * ptr = malloc(100);
			..
			free(ptr);

		In C++:
			Person p = new Person();
			delete p;

		In Java:
			Product p = new Product();
			we don't release the memory, GC cleans up the memory allocated for "p" when it no loger used/reachable


		a() {
			Product one = new Product();
		}

		main() {
			Product p = new Product();
			a();
			// other lines of code

			p.getName();
			..
			p = null;

			// here p is eligible for GC
		}

		GC thread is handled internally by JRE

		System.gc(); // a request to start GC

		Short Term GC:  frequently running GC, clears objects which is of not reachable, objects which are
			still in use and not able to clear will be moved to Old Generation.
			After Short term GC, EDEN area is empty and ready for newly created objects
			Scavenger type

		Full Term GC: runs for example after every 10 cycles of Short term
======================================================================================

	keyword: abstract

	1) abstract classes can't be instantiated

		public abstract class Product {

		}

		Product p = new Product(); // error
		Product p = new Tv(); // valid

	2) abstract methods: methods without body
		this enforces all inherited classes to compulsorly override the method

=====================================================================================

	using RTTI ==> Runtime Type Indentification.
	Given an object at runtime we get all it's methods, constructors, ...


	Product p = new Product();
		p.getId();
		p.getName();

	Ptr is to a method

		ptr ===> getId()

	============

		iNHERITANCE Recap:
			1) every class extends Object class in Java
			2) Object class is the root class
			3) Java doesn't support multiple inheritance
				class A extends B , C { } // not valid
			4) uses "extends" keyword for inheritance
			5) In Java method calls are always dynamic binding
			6) override is a concept where the sub class redifines the methods 
				present in base class
			7) overload is a mechanism where method name is same, but arguments are different

				class Test {
						public static void add(int x, int y) {

						}
						public static void add(int x, int y, int z) {

						}
						public static void add(String x, int y) {

						}

				}

				Test.add(3,4);
				Test.add(3,4, 5);
				Test.add("Hello",4);
	================================================

		Realization Relationship
		========================
			A object/component will realize the behaviour specified by other in order to communicate.

		==> one object specifies the protocol, other object implements that protocol so that 
			communication between them can happen

		==> this happens using "interfaces"

			Real world interface: HDMI, VGA, USB Port

			Tv specfies HDMI protocol
				Settop box implements HDMI
				DVD player implements HDMI

				the way settop box and DVD implement vary.

			==========

			In java interfaces are declared using "interface" keyword
			interface will just declare functionalities and no implementation

			interface EmployeeDao {
					void addEmployee(Employee e);
					Employee getEmployee(int id);
			}

			as of java <8 : all methods in interface are abstract and public by methods


			Why should we program to interface?
				1) DESIGN
				2) IMPLEMENTATION
				3) TESTING
				4) INTEGRATION
				5) loose coupling

				META-INF/services/com.example.CodecSet



			client refers to different implmentation classes using interface.

			one line of code is getting changed in client to switch to different strategies
				from MySQL to MongoDB to File,...

			But the problem in real-world: clients are of heterogenous type [ mobile, web , standalone]
			and desktop clients might have been deployed across world
			Changing all the client codes is not feasable.

			Decouple the hard-coded implementation class and use configuration files

			create META-INF/services folder under "src"
			create a file with fully qualified "interface" name [ com.cisco.dao.MobileDao]
			within the file add a line which implementation class has to be used
			com.cisco.prj.dao.MobileDaoMySQLImpl


			ServiceLoader approach advantages:
				a) Client is loosely coupled, no changes in client ever
				b) switching between strategies done by only changing "META-INF/services/pkg.interfacename"
				c) Client need not know which implementation class is used

		========================================

											Dance d = new Hero();
											d.dance();

											Fight f = new Hero();
											f.fight();
											f.swim(); //error
	interface Dance { 							
		void dance();
	}

	inteface Swim {
		void swim();
	}

	interface Fight {
		void fight();
	}

	// Actor is capable of dancing, Actor realizes dance capability
	class Actor implements Dance {
		public void dance() { 
			// logic 
		}
	}
	// hero is an actor and capable to dance. also he can swim and fight
	class Hero extends Actor implements Swim, Fight{
		public void swim() {

		}
		public void fight() {

		}
	}
	==
	 In real world: Hero knows to swim, dance and fight.
	 StuntMaster directs fight sequence.
	 Choregrapher directs dance sequence
	 Swim instructor directs swim of hero

	 ==============================

	 	names
		["Clooney", "Brad","Angelina","Lee"]

		numbers
		[56,72,12,30,5]


		to sort/max.min what do you do?
			you compare objects then re-arrange

		To perform operations like sort , max, min java has an interface Comparable


		interface Comparable {
				int compareTo(Object obj);
		}

		class String implements Comparable {
				//code
				public int compareTo(Object obj) {
					// logic to return ASCII/unicode charater difference
					// A with B ==> -1
					// A with C ==> -2
				}
		}
		[ "Angelina",  "Brad", "Clooney","Lee"]
		// ocp
		void sort(Comparable[] elems) {
				for i = 0 to elems length
					for j = i + 1 ...
						if(elems[i].compareTo(elems[j]) > 0) { // "Clooney".compareTo("Brad")
								swap code
						}
		}
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");

		class Product implements Comparable {

					public int compareTo(Object obj) {
							decide to compare based on name, qty, price ,id
					}
		}	


		========

		Good practice: all entities are implementing comparable, equal()

		==============================================================================

	 	interface Flyable {
	 		void fly();
	 	}

	 	Flyable f = new Flyable(); // error, can't instantiate Flyable

	 	class Bird implements Flyable {
	 			public void fly() {

	 			}
	 	}

	 	class AeroPlane implements Flyable {
	 			public void fly() {

	 			}
	 	}

	 	Flyable f = new Bird(); // valid
	 	Flyable f = new AeroPlan(); // valid
	 		===

	 		Anonymous class

	 		Flyable f = new Flyable() {
	 			public void fly() {
	 					s.o.p("Jumo from 10th floor!!!")
	 			}
	 		};

	 		Product p = new Product() {
	 			public boolean isExpensive() {
	 					// default
	 			}
	 		};

	 	interface Consumer {
	 		void action(Object obj);
	 	}

	 	void forEach(Object[] elems, Consumer cons) {
	 			for(Object o : elems) {
	 				cons.action(o);
	 			}
	 	}

	 	Dummy.java
	 	class Dummy implements Consumer {
	 			public void action(Object obj) {
	 				write obj to database;
	 			}
	 	}

	 	String[] names = ["Clooney", "Brad","Angelina","Lee"]
	 	Dummy d = new Dummy();
	 	
	 	forEach(names, d); 

	 	// Anonymous class
	 	Consumer c = new Consumer() {
	 			public void action(Object obj) {
	 				System.out.println(obj);
	 			}
	 	}
	 	forEach(names, c);

	 	==============================================

	 	Without generics:

	 	class IRectangle {
	 			int width;
	 			int breadth;
	 	}

	 	class DRectangle {
	 		double width;
	 		double breadth;
	 	}

	 	class SRectangle {
	 		String width;
	 		String breadth;
	 	}


	 	Generics in Java: Genric Type is  <T>

	 	Generic class

	 	class Rectangle <T> {
	 		T width;
	 		T breadth;
	 		...
	 	}


	 	Rectangle<Integer> r1 = new Rectangle<Integer>(4,5);
	 	Rectangle<Double> r2 = new Rectangle<Double>(1.4,4.5);
	 	Rectangle<String> r3 = new Rectangle<String>("1 inch","5 inch");

	 	Limitation is Generic type can be only object and not primitive

	 	Rectangle<int> ; // not valid

	 	Rectangle<double>; // not valid

	 	Integer, Double , Float are type-wrapper classes for int, double and float:

	 	Generic interface:

	 	public interface Comparable<T> {
	 		 public int compareTo(T o);
	 	}

	 	class Product implements Comparable {
	 			@Override
				public int compareTo(Object o) {
					Product other = (Product) o;
					return (int) (this.price - other.price) ;
				}
	 	}


	 	class Product implements Comparable<Product> {
	 			@Override
				public int compareTo(Product o) {
					return (int) (this.price - other.price) ;
				}
	 	}

	 	public interface Consumer<T> {
	 		void accept(T t);
	 	}

	 	=================================

	 	// Anonymous class
		doTask(names, new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// Lambda exressions can be used as a shorter form of anoymous class


		doTask(names, (String t) -> {
				System.out.println(t);
			}
		});

		---

		doTask(names, (t) ->  System.out.println(t) );

		doTask(names, t -> System.out.println(t));

		===================================================

		Exception handling in Java:

			An abnormal condition that arises during program execution is an exception.

			In Java exceptions are represented as objects which provides the following info:

			a) What went Wrong?
			b) Why did it go wrong?
			c) Where?

		====================

		public class Test {

			public static void main(String[] args) {
				System.out.println("Hello !!");
					doTask();
				System.out.println("Bye!!!");
			}

			private static void doTask() {
				int x = 10;
				int y = 0;
				System.out.println("Result : " + x / y);
				System.out.println();
			}
		}
		Hello !!
		Exception in thread "main" java.lang.ArithmeticException: / by zero
			at Test.doTask(Test.java:13)
			at Test.main(Test.java:6)

	==========================================


		Checked Exceptions:

	public class Test {

		public static void main(String[] args) {
			System.out.println("Hello !!");
				doTask();
			System.out.println("Bye!!!");
		}

		private static void doTask() {
			 try {
				FileInputStream fis = new FileInputStream("a.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	=== 

	unchecked exceptions are supposed to be handled using conditional statements:

		private static void doTask() {
				int x = 10;
				int y = 0;
				if( y ! = 0) {
					System.out.println("Result : " + x / y);
				}
			}

		private static void doTask(Product p) {
			if( p != null) {
				System.out.println(p.getName());
			}
		}

	====================


public class Test {

	public static void main(String[] args) {
		System.out.println("Hello !!");
		try {
			doTask();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Bye!!!");
	}

	private static void doTask() throws FileNotFoundException {
		doAnotherTask();
	}

	private static void doAnotherTask() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("a.txt");
	}

}
===============

Day 3
=====	
	Recap:
		interface: contains abstract methods and constants, it can't have instance varibles	

		interface Test {
				int x = 100; // become a constant;
		}

		Test.x = 120; //error

		Can't instantiate a interface.

		class implements interface [ Realization relationship]

		class can implement multiple interfaces

		Anonymous class: class without a name, used to create objects of interface/abstract class
			without creating one more java file

		Lambda can be used instead of anonymous class only if the interface has one method to implement.

		interfaces with one method are refered as Functional interface:

		@FunctionalInterface
		public interface Computation {
				int compute (int x, int y);
		}

		============

		interface Dance {
			void dance();
		}

		interface Fight extends Dance {
			void fight();
		}

		class Hero implements Fight {
				void dance() {}
				void fight() {}
		}

		================================================================

		Java Collection Framework
			==> Data containers 
			Array is a data container
				Fast access
				Limitations: can't grow / can't shrink
				Needs contiguous memory
		JCF provides many data containers.
			JCF has 
				a) interfaces
				b) implementation classes 
				c) utility classes [ sort, binarySearch, max, min, shuffle, reverse]


		Comparable vs Comparator

		Comparable is used as natural way of comparing
			==> logic is written in entity class
			==> for Strings based on ASCII/ Unicode character values
			==> Product: based on product id [ PK]
			==> Employee: based on employee id [ Primary Key]

		Comparator is used by client to specifiy a certain way of comparing.
			==> logic is written in client code
			==> I may want strings to be compared based on length
			==> on client wants products to be sorted based on price
			==> another client wants products to be sorted based on name
			==> another client wnats products to be sorted based on category

		String[] names = {"Clooney", "Brad","Angelina","Lee"};

		Natural way of sorting order will be:
			Angelina, Brad, Clooney, Lee

		But we can also sort them as: [ length as criteria]
			Lee, Brad, Clooney, Angelina

		public interface Comparable<T> {
			    public int compareTo(T o);
		}

		class Product implements Comparable<Product> {
				public int compareTo(Product o) {
						this ==> p1
						o ==> p2
				}
		}

		p1.compareTo(p2);



		@FunctionalInterface
		public interface Comparator<T> {
			int compare(T o1, T o2);
		}


		client code:

			Comparator<Product> comp = new Comparator<Product>() {
					public int compare(Product o1, Product o2) {

					}
			};	

			compare(p1,p2); // "this" refers to "client"


			class Arrays {

				sort(Comparable[] elems) {
						for i
							for j 
								if(elems[i].compareTo(elems[j]) > 0)
									swap
				}


				sort(Object[] elems, Comparator comp) {
					for i 
						for j 
							if(comp.compare(elems[i], elems[j]) > 0) 
								swap
				}
			}


			Arrays.sort(products, (p1,p2) -> ); here p1 and p2 type inference to Product
			because products is a collection of type Product

	==============================================

	interface Computation {
		int compute(int x, int y);
	}

	void sample(Computation comp){

	}


	sample((x,y) -> x + y);

	Computation sum = (x,y) -> x + y;

	sample(sum);

	=====================================================


	List list = new ArrayList()

	List list = new LinkedList()

	List list = new vavr list / apache list

	good practice : use interface to point to implementation

		List list = new ArrayList();

		Avoid using implementation as reference

		ArrayList list = new ArrayList(); // works but tightly coupled to ArrayList
	==========
	Avoid Heterogenous collection:

	List list = new ArrayList();
		list.add(12);
		list.add("A");
		list.add(new Date());
		list.add( new Product());

		// Not Type safe
	for(int i = 0; i < list.size(); i++) {
		if(list.get(i) instanceof String) {

			} else if(list.get(i) instanceof Date) {
			
			}
			...

	}

	================================

	Prefer generic type of container:

	List<String> list = new ArrayList<String>();
		list.add("A");
		list.add(new Date()); // ERROR


	============================================

		Functional style of programming:
			using High Order Functions:

			High Order Functions are functions:
				a) accept other functions as arguments
				b) returns a function

			Commonly used HOF are:
				a) filter
				b) map
				c) reduce
				d) forEach
				e) sort
				f) limit
				g) skip

		functional style of programming is not tightly coupled to state of object.

		Example: Account.java deposit(double amt) { this.balance += amt; }
			The deposit method can be used only on Account type of object

		void filter(predicateFn) {
				create  filteredcollection
					traverse through input collection
						if(predicateFn) {
								store into filteredcollection
						}
					end travers
					return filteredcollection

		}


		=======

		void map(transformFn) {
				create  collection
					traverse through input collection
						 collection.add(transformFn(input));
					end travers
					return collection

		}

		==================

		intermediary operations: map, filter, flatMap, skip, limit

		terminal operations: forEach, collect, reduce

		If we don't have terminal operator data won't flow in the stream;

		Data won;t flow , because no terminal opertion:
		products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.map(p -> p.getName());
		==============================================

		reduce is to get aggregates [ sum, count, max, avg]
			select sum(price) from ....

		reduce returns a single value.
			

		============================

		Set ==> unique collection

		HashSet uses hashCode() and equals() to identify duplicates and position of object
		in collection


		===
		HashCode: [ numerical representation of object]
			1) 2 similar objects should have same hashcode
			2) 2 dis-similar objects can also have same hashCode


		class Rectangle {
				int w, b;

				public int hashCode() {
					return w;
				}
		}

		Rectangle(4,5) ==> 20
		Rectangle(5,4) ==> 20
		Rectangle(20,1) ==> 20
		Rectangle(10,2) ==> 20
		..............

		Rectangle(4,5) ==> 20


		List ==> faster add/remove operations

		Set ==> Avoid using it if too many add / remove happening 
======================================================================================

	HashSet is an implementation of Set interface.
	uses hashCode() and equals() to identify duplicates.

	If 2 objects has same hash code, the equals() on those objects are called.
	If equals() returns true, then the object is treated as duplicate.

	If hashCode is same and equals() returns false, it's not a duplicate bu hashCode collides,
	In this senario internally a linled list is created to store the element with same index.


	UI
		accedentally clicks on "add button" twice before the data is sent to server

	Set -> you can't do : sort, shuffle, reverse


=====================================

	Map is a container to store data in the form of key/value pair:
		Example: Dictionary, DNS register [ IP Address is KEy / Domain name is value],

		WebEx: Panelist | people
				Attendees | people
		========

		Shopping Cart
			Key is Product | Value is qty

		Key has to be unique | value can be duplicate

		=============

		HashMap is an implementation of Map interface

			Good practice: if 75% of buckets are full capcity doubles to avoid hash collisions

			Whenever capcity doubles, re-hashing happens

			new HashMap<String, Integer>(16,0.75f);

				intial capacity is 16, re-hashing happens if 75% is full


		Key is "Computer"
			first it adds "p1" as value

			"p1" and "p3"
			it overwrites "computer" now the value is [p1, p1]

	===========================================================================================

		Java Concurrent Programming [ Multithreaded applications]

		-------------

			Process --> Program in execution, every process should have at least one unit of work executing.
			Unit of work --> thread

			Single threaded applications will have only one unit of work
				==> notepad, calculator

			In applications if we have many units of work concurrently running we say it as multi-threaded app.
				==> Eclipse, Word, Browser, ..

			Word:
				-> Document editing is one unit of work
				-> Spell check
				-> Grammer check
				-> auto save

			Eclipse:
				--> editing a file
				--> Syntax check
				--> Intellisense
				--> autosave
			Browser:
				--> fetch data from server 
				--> rendering [ fetched data is converted to UI]
				--> event handling

			===========
			
			Why do I need multi-threaded application?
				1) Avoid starvation	 ==> Better User Experience
				2) Optimization of available resources.
					1 Thread -->  1 CPU
					sharing objects on heap between threads
				3) Each task life cyle can be independent of other

			============================

			Java provides Runnable interface, any code which has to run as a thread needs to implement this interface

			interface Runnable {
					void run();
			}

			class SpellCheck implements Runnable {
					public void run() {
						doSpell();
					}

					public void doSpell() {

					}
			}

			class GrammerCheck implements Runnable {
					public void run() {

					}
			}


			======

				Thread.java => provides Thread control methods:
					start()
					sleep(long ms)
					yield()
					join()
					interrupt()

					deprectated: suspend(), resume(), stop()
==========================================================================

	Day 4
	=====
	Java Concurrent Programming:
		Runnable interface ==> run()
		Thread class: start(), sleep(), join(), interrupt(), yield()

		Thread.currentThread(); ==> reference to the thread which is currently in running state

	Each thread has its own stack, all threads share classes loaded and objects created.

	===========================================

		Thread Safety
		-------------
			A member is said to be thread safe if it doesn't get effected in multi-threaded environment

	Local variables ==> Thread safe; each thread has a seperate stack
	instance variables ==> Not thread safe; reside on heap; heap is shared by all threads

	==
	synchronized ==> marks it as critical section, this enforces the thread to acquire lock before entering the
		method, threads are not allowed to enter this method without lock
		once threads come out of the method, lock is released


	
		synchronized acquires [Mutex/Lock/Monitor ]

		wait releases [Mutex/Lock/Monitor]

		if we invoke wait() without synchronized, trying to relase which you have not acquired.

		sleep() doesn't acquire [Mutex/Lock/Monitor]

	========================================================

	In enterprise applications: we generally don't create threads using "new" keyword, instead we use thread pools

	Issues:
		latency in creating a thread and destroying a thread
		can't limit the number of Threads

	Solution is use Thread pools

	====================================

		Java also provides Lock API which can be used instead of synchronized

			synchronized: 
					only the owner can release
					only one lock per object
			Lock API:
					other threads can also release the lock
					many locks per object.

			Lock API: lock is released just by callin "unlock()"

			always release lock in finally block: finally block gets executed irrespective of
			exception occurs or not


			try{
					int x = 10;
					int y = 0;
					int res = x / y;
			} catch(Exception ex) {
					s.o.p("problem")
			} finally {
					s.o.p("done")
			}

			problem, done

			=========


			try {
					int x = 10;
					int y = 2;
					int res = x / y;
			} catch(Exception ex) {
					s.o.p("problem")
			} finally {
					s.o.p("done")
			}

			done
============================================================================
	
		Lock Vs synchronized


		Here we need to lock both the accounts:

		class BankingService {
				public void transferFunds(Account from, Account to, double amt) {
					synchronized(from) { // lock from
							synchronized(to) { // lock to
									from.withdraw(amt);
									to.deposit(amt);
							}
					}
				}
		}

		DeadLock:
		SB105 to SB101 , 5000 transfer : Both SB105 and SB101 needs to be locked
		synhronized blocks instead of synchronized methods

		T1 ==> SB105 to SB101 , 5000 transfer

		T2 ==> SB101 to SB105 , 5000 transfer

		with Locking API:

			class BankingService {
				public void transferFunds(Account from, Account to, double amt) {
					if(from.balLock.tryLock(100)) {
						try {
							if(to.balLock.tryLock(100)) {
								try {
										from.withdraw(amt);
										to.deposit(amt);
									}
								} finally {
										to.balLock.unlock();
								}
						    }
					   } finally {
					   		from.balLock.unlock();
					   }
					}	
				}	

		T1 ==> SB105 to SB101 , 5000 transfer

		T2 ==> SB101 to SB105 , 2000 transfer


		=========================================================

		Callable and Future:

		Callable can be used instead of Runnable :

			interface Runnable {
					void run();
			}
			Runnable doesn't return a value
			Runnable doesn't throw an exception

			interface Callable<T> {
					T call() throws Exception;
			}


			callable can return a value
			callable can throw an exception



			Future is a promise/ Async


			class AThread implements Runnable {
				run() {}
			}

			class BThread implements Runnable {
					BThread(AThread t) {

					}

					run() {
							code
							t.join();
							code
					}
			}


			main() {
					AThread t1 = new AThread();
					BThread t2 = new BThread(t1);
					t1.start();
					t2.start();
			}

			============================================================

			JDBC
				Java Database Connectivity
				==> It's an integration API to connect to RDBMS

			Java provides interfaces, implementation classes are provided by database vendors


			Steps:
				1) load classes provided by database vendors:
					Class.forName("com.mysql.jdbc.Driver");

					Class.forName("oracle.jdbc.OracleDriver");
				2) Establish a database connection:

				Connection con = DriverManger.getConnection(URL, USER, PWD);

				URL:
					jdbc:mysql://192.168.12.20:3306/emp_db

					jdbc:oracle:@198.44.21.44:1521/emp_db

				3) Send SQL statements:
					a) Statement
						if SQL doesn't take IN parameters
						select * from products
					b) PreparedStatement
						if SQL accepts IN parameters 
							select * from products where category = ?

							"?" is an IN parameter

							insert into products values (?,?,?,?)
					c) CallableStatement
						--> StoredProcedure of database
				4) ResultSet
					is a cursor to fetched records from database / table

				5) finally release the connection in "finally" block
			============================================================================

			MySQL installation complete.

			Maven ==> Java Development tool / Automation tool
				==> Dependency managment
					Building enterprise application
					my application will use n number of 3rd party libraries,
					all these libraries might be present on CDN,
					these libraries are in the form of "JAR" files
					each one of the "jar" has an identification
						"artifactID", "groupId" and "version"

					"groupId" --> organization + project [ com.amazon.shop]
					"artifactID" --> module name [ customermodule]
					"version" : 1.0.0

				pom.xml ==> Project Object model
						==> goals [ clean, compile, test, deploy]
						==> dependencies
							<dependency>
								<groupId>mysql</groupId>
								<artifactId>mysql-connector-java</artifactId>
								<version>5.1.27</version>
							</dependency>

						Without MAven: every "jar" has to be downladed and added project
						==> Different team members might download different versions from
						different locations, these can lead to abnormality

						https://www.findjar.com/search?query=mysql-connector&more=false

						===

						Maven provides a standard for all developers:
							Maven projects are compatable to any IDEs
							Using maven we can specify which versions has to used


						MySQL:
						 create database cisco_2020;

						 use cisco_2020;

						 create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, category VARCHAR(100));


						 insert into products values (0, 'iPhone', 78000.00, "mobile");
						 insert into products values (0, 'Mouse', 500.00, "computer");
						 insert into products values (0, 'Samsung', 278000.00, "tv");

						 select * from products;

						======================
=========================================================================================

	Engines:
		Servlet engine is used to serve dynaminc content using Java as programming language
		NodeJS ==> to serve dynamic content using JavaScript as programming language
		ASP.NET engine ==> serve dynamic content using C# or VB.NET
		PHP

		When a client makes a request,
			==> servlet engine creates 2 objects [ request and response]
			==> request encapsulates all info coming from client [ form data + request params + browser]
			==> response is used to write data back to client

			==> engine assigns a thread from pool to each client handling

			==> Engines maps a resource to URI

				http://server:port/products

				http://server:port/orders


		Web Archive: "war" files like "jar"

		

		class LoginServlet extends HttpServlet {
			// code
		}

		web.xml <== deployment descriptor
		Engine reads this and creates object of LoginServlet and Product Servlet
		<servlet>
			<servlet-name> loginservlet </servlet-name>
			<servlet-class> com.cisco.web.LoginServlet </servlet-class>
		</servlet>

		<servlet>
			<servlet-name> productservlet </servlet-name>
			<servlet-class> com.cisco.web.ProductServlet </servlet-class>
		</servlet>


		<serlvet-mapping>
			<servlet-name> productservlet </servlet-name>
			<url-pattern> /products </url-pattern>
		</servlet-mapping>
		<serlvet-mapping>
			<servlet-name> loginservlet </servlet-name>
			<url-pattern> /login </url-pattern>
		</servlet-mapping>

		Alternate to web.xml is Annotation

		===============

		Jetty / Tomcat are web servers with Servlet engine

		Application Servers : JBOSS, Weblogic, WebSphere, GlassFish

		===

		1 hour ==> Database application ==> web application

		Spring Boot + Hibernate [ JPA] ==> RESTful web service


		
		Day 5:

		JDBC and Web application development:
		=====================================

		Java Database connectivity [ Integration API to connect to RDBMS]
		JDBC is a collection on interfaces, implementation classes are provided by database vendors

		Connection, DriverManager, Statement, PreparedStatement, ResultSet

		Traditional Web application development converts dynamic data into HTML and sends to client.
		==> Java Technology [ Servlet techonolgy] uses servlets to convert content into HTML
		==> .NET [ ASP.NET converts content into HTML
		==> PHP converts data into HTML

		===> Clients are light-weight, just needs to understand HTML [ Browser]


		Servlet Technology:
			==> HTML for static content
			==> Servlet for dynamic content
			==> JSP for static + dynamic content
			==> Filter, Listeners

			===
			<scope>provided</scope>
				uses this dependency for compilation but don't include in packaging [ war]
				this will be provided by the target environment [Tomcat, jetty, GlassFish, jBOSS, Weblogic]

			Default: 	we create java independent modules
				<packaging>jar</packaging>
				customermodule.jar

			Building web application:
			<packaging>war</packaging>
				databaseexample.war
		====

			main --> webapp folder is created for "war" type of maven projects
			"webapp" is the folder where static contents like "html", "css", "js" , "images" ,... should be stored

			"webapp" also contains "jsp" [ static + dynamic]


			"servlets" will be written just like any other class "src/main/java"


				only "war" files can be deployed on Web Servers with servlet engine


			"war" ==> web archive

			"ear" ==> enterprise archive
					Servlets [war] + "EJB" [Distributed computing] + "JNDI" + "JMS" +...

					"ear" can't be deployed on Tomcat/ Jetty; we need application servers like 
						"GlassFish", "JBoss", "Weblogic" , "WebSphere", 


			==========================
			

		Servlet API:

		public void service(HttpServletRequest req, HttpServletResponse res)
						|
						V
		public void doGet(HttpServletRequest req, HttpServletResponse res)
		public void doPost(HttpServletRequest req, HttpServletResponse res)
		public void doPut(HttpServletRequest req, HttpServletResponse res)
		public void doDelete(HttpServletRequest req, HttpServletResponse res)


		request and response objects created by the engine for ther user request
		is injected to service(req, res);
		within service() method there is a switch statment
		if method of request is GET ==> call doGet
		if method of request is POST ==> call doPost

		============

		GET request: is the default request : address bar, hyperlink

		POST, PUT, DELETE request: has to be explicitly mentioned

		GET --> to fetch data
		POST --> create a resource
		PUT --> update
		DELETE --> DELETE a resource


		==


		int x = 10;

		String s = "Hello";

		s + x; //valid "Hello10"


		Run As ==> Maven build[2] Goals: clean package

		\target\databaseexample-1.0.0.war

		this war file can be deployed on any server



		Multi-stage processing of data

		MVC Architecture: Model View Controller

		M ==> Model is business data /logic [ entity , dao]

		C ==> Controller [ Servlet ]

		V ==> View [ JSP, HTML]

		===================================================


		for(Product p : products) 


		<c:forEach items="${products}" var = "p" >

			 ${p.id}  ==> same as p.getId()

			 ${p.name} ==> p.getName()
		</c:forEach>


		Use JSP for static + dynamic presentation code
		HTML ==> pure static
		Logic + controller

		==============================================================

		Frameworks:

		ORM ==> Object Relational Mapping

		class <===> database tables are mapped

		CRUD operations are performed by ORM frameworks:--> eliminate lots of plumbing code

			save(p); ==> save is an ORM framework method, which internally
				does the follwoing things:
					a) establishes database connection
					b) Creates PreparedStatement
					c) sets IN Parameters
					d) executes executeUpdate();
					e) close connection

			find(Product.class,4) ==>
					a) establish connection
					b) create Statement
					c) execute SELECT statment
						select * from products where ID = 4;
					d) use REsultSet to traverse thro record
					e) return matchin record
					f) close connection

		ORM frameworks: Hibernate, KODO, OpenJPA, topLink, ...

		Hibernate is the most popular ORM framework by JBOSS [ RedHat]

		JPA ==> Java Persistence API is a specification to user ORM
			[ think JPA as interface; Hibernate, TopLink, etc as implementation]



			EntityManager em = ....

			em.save(p);

			=====================================

			Online Order application
				entities:
					Customer
					Product
					Order
					LineItems
					Address
					Payement

			Product ==> info about inventory data
			ID: 120
			Name: Parley Biscuit
			QTY: 10000
			Price: 5.50

			LineItem ==> how you purchased the product
			How you purchase "Parley Biscuit"
			ID: 3,
			"orderid": 450
			"product" : 120
			"qty" : 10
			"price" : 450 [ 10 * 5.5 - discount]



		========

		MetaData: Annotations are meta data

		@Column(name="order_date")
		@Temporal(TemporalType.TIMESTAMP)
		private Date orderDate = new Date();

		================

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="order_fk")
	private List<LineItem> items = new ArrayList<>();


		Order o1 has items i1, i2, i3

		without cascade:
			save(o1);
			save(i1);
			save(i2);
			save(i3);
			--
			delete(i1); delete(i2); delete(i3); delete(o1);


		With Cascade.ALL

			save(o1); // internally it manages all items and they get saved

			delete(o1); // deletes order and its items


	FETCH:
		by default its LAZY ( n + 1 hits)
			select * from orders
			then
			select * from items where order_id = ..

			n + 1: ==> if 100 orders are there
				1 ==> select * from orders
				then for each order :
				 select * from items where order_id = 1 
				  select * from items where order_id = 2
				  ..
				   select * from items where order_id = 100

		EAGER:
			uses join and fetches at one shot orders and its items


spring.jpa.show-sql = true
		ORMs generate SQL, we don't write SQLs
		using this configurations we can inspect the SQLs generated by ORM
		use this in development stage
		save(p); ==> what SQL is generate
		find(Product.class, 1); ==> what SQL is generated

spring.jpa.hibernate.ddl-auto = update
		ORMs maps class to table if table already exists , as in Product ===> products
		If tables are not present, ORMs creates tables
		"DDL" ==> Data Definition Langage [ CREATE TABLE, ALTER table, DROP table]

		hibernate.ddl-auto = create
			drop tables and re-create for every run of the application
			useful in testing environment

			5 records are inserted
			test case is written to see if 5 records are present in table



spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
	we need to tell ORMS SQL should be generated for MySQL


	 jdbc:mysql://localhost:3306/cisco_2020?createDatabaseIfNotExist=true

	 if cisco_2020 does not exist
	 create database cisco_2020;




	 class Movie {

	 		@ManyToMany
	 		@JoinTable(
 				 name = "movie_actor", 
  				joinColumns = @JoinColumn(name = "movie_id"), 
  				inverseJoinColumns = @JoinColumn(name = "actor_id"))
	 		private List<Actor> actors = new ArrayList<>();
	 }


	 class Actor {

	 }

	 ==================================================================


	 Spring Framework:
	 	lightweight container for building enterprise application,
	 	Spring containers provides 
	 		a) Dependency Injection [ Inversion Of Control]
	 		b) Enterprise Integration APIs [ EAI]
	 		c) Simplifies Building Web applciations and RESTful Webservices
	 		d) AOP


	 Spring instantiates objects of class which has one of these annotations:
	 	@Component
	 	@Repository
	 	@Service
	 	@RestController
	 	@Configuration
	 	@Controller

	 	==========

	 	@SpringBootApplication
	 		has @ComponentScan
	 			scans our classes for any of above mentioned annotated classes and objects are created
	 		has @EnableAutoConfiguration
	 			scans jars file and creates required objects for the application:
	 				for example:
	 					a) we need EntityManager for Hibernate
	 					b) creates database connection pool
	 							note DriverManager is used to get single connection
	 							In enterprise apps need to have database connection pool
	 							HikariCP ==> library for database connection pool
	 							expeliclty i can add some other jar "c3p0" 

	 ====================


	 USe @RestController for RESTful web service controller

	 @Controller for traditional web application

	 @Repository is for DAO classes

	 @Service is for Service classes

	 @Component is for utility classes

	 @Configuration is for configuration
	 ==================

	 Spring DATA jpa will internally generate implementation classes for interfaces of type JpaRepositry

	 public interface ProductDao extends JpaRepository<Product, Integer> {

	}



	Spring will create:
		@Repository
		class ProductDaoJpaImpl implements ProductDao {

			save(Product p ) {

			}

			Product find(int id) {

			}
			List<Product> findAll() {

			}

			....
		}

		=====

		 public interface CustomerDao extends JpaRepository<Customer, String> {

	}


	@ResponseBody converts Java ==> Representation [ XML or JSON or CSV]

	@RequestBody converts Representation ==> Java 


	POST  http://localhost:9999/api/orders

	BODY:

		{
			"customer" : {
					"email" : "b@cisco.com"
			},
			"total" : 234446.33,
			"items" : [
					{
							"product" : { "id" : 3},
							"qty": 3,
							"amount" : 35666.66
					},
					{
							"product" : { "id" : 1},
							"qty": 1,
							"amount" : 90000.00
					}
			]
		}

	============

		EJB ==> Enterprise Java Bean
			designed for distributed computing
			Objects can reside in different address space and communicate with each other

			Server has to JAVA, client can be any language
			binary data [ Marshalling / unmarshalling]

		
		Spring is used instead of EJB
			@Inject ==> @Autowired
			
			Microservices : light weight ==> JSON is a carrier of data


		JMX ==> Java Management Extension