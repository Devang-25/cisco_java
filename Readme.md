
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