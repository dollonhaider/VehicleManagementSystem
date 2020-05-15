# Build a Vehicle Management Project with Java and SQlite Database

## Getting Started

-> Clone the repository: https://github.com/dollonhaider/VehicleManagementSystem

-> Download the project

## Setup Local Environment

1 - Setup SQLite environment

	Step 1 −> Go to SQLite download page( https://www.sqlite.org/download.html ), and download precompiled binaries from Windows section.

	Step 2 −> Download sqlite-tools-win32-x86-3310100.zip zipped files.

	Step 3 −> Create a folder C:\>sqlite and unzip above zipped file in this folder, which will give you sqlite3.def, sqlite3.dll and sqlite3.exe files.

	Step 4 −> Add C:\>sqlite in your PATH environment variable and finally go to the command prompt and issue sqlite3 command, which should display the result.

2 - Setup SQLite JDBC Driver

	Step 1 −> Download latest version of sqlite-jdbc-(VERSION).jar from sqlite-jdbc(https://bitbucket.org/xerial/sqlite-jdbc/downloads) repository.

	Step 2 −> Add downloaded jar file sqlite-jdbc-(VERSION).jar in your class path.
		   (Go to System Properties -> Click on Environment Variables -> Under user variables for user find classpath 
		
		 1. If classpath does not exist click on new If classpath exist click on that 
		 
		 2. put variable name "classpath" and put variable value "sqlite-jdbc path"
	      ( For me it is C:\Program Files (x86)\Java\jdk1.8.0_181\jre\lib\ext\sqlite-jdbc\sqlite-jdbc-3.30.1.jar;.; )
		  
		 3. make sure you have put ;.; after the mentioned path
		 
		 4. After setting the classpath restart your pc
		 
		 5. If classpath already exists, click on that -> click new -> add sqlite-jdbc path as mentioned above
		 
##To Run 
 1. Open a command prompt in the project directory
 2. Enter the following command
 
 #$javac Start.java
 #$java Start
		 
	
		

