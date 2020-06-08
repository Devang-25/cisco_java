
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
	10:40 resume after break

	








		