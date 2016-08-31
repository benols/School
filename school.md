Installation 

1 install GlassFish
2 install apache-derby

1. Start the Derby database server,e.g.: /opt/jdk/db/bin/startNetworkServer. 
2. Create a connection pool for the database in GlassFish. (This will also, automatically, create the Derby database itself.) 

1. Start up GlassFish: 
	asadmin start-domain 
2. Activate the GlassFish administration consol: 
	asadmin
3. Create the connection pool with a command like the following: 
	create-jdbc-connection-pool --datasourceclassname org.apache.derby.jdbc.ClientDataSource --restype javax.sql.XADataSource --property portNumber=1527:password=admin:user=admin:serverName=localhost: databaseName=school:connectionAttributes=\;create\\=true school_derby_pool. 
3. Next, create a GlassFish JDBC resource. (This resource will be used in the JPA conﬁguration ﬁle to reference the connection pool.) 
Issue the following command inside the GlassFish administration consol: 
	create-jdbc-resource --connectionpoolid school_derby_pool jdbc/school 
4. Now the database and the application server are all set up. 
	
It only remains to conﬁgure the web application itself. 
1. CreateaJPAconﬁgurationﬁle,andaddittothefollowingdirectoryin yourMavenproject: 	
	src/main/resources/META-INF/persistence.xml. 
	i.e:
	
<?xml version="1.0" encoding="UTF-8"?>
<persistence
        version="2.1"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="school" transaction-type="JTA">
        <jta-data-source>jdbc/school</jta-data-source>
        <properties>
            <property name="eclipselink.logging.exceptions" value="false"/>
            <property name="javax.persistence.schema-generation.database.action" value="create"/>
        </properties>
    </persistence-unit>
</persistence>

2. Compile and deploy your application: 
	mvn package 
followed by 
	asadmin deploy target/School.war 
