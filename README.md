# HijrDroid

This is sample android project that uses mybatis for accessing database sqlite in android, several adjustment code in mybatis source to get working on android application. For developer who wants to create multi platform application both on android and desktop using java, just make once for xml mapping file, DAO and model/domain classes.

## Library
- MyBatis (https://github.com/mybatis/mybatis-3)
- Droid Java Beans (https://github.com/dthommes/droid-java-beans)
- SQLDroid (https://github.com/SQLDroid/SQLDroid)

## Testing
This project using Robolectric for unit testing (https://github.com/robolectric/robolectric), its very helping to test all functions from activity as controller to database with Data Access Object (DAO), its faster than using emulator. Three (3) files that you must configure regarding using the testing method, unit testing or emulator/device testing:
- src/assets/mybatis-config.xml
```xml
<property name='url' value='jdbc:sqlite:/data/data/id.co.hijr.app/databases/app.db'/>
```
- src/java/id.co.hijr.app.core.MainApp.java
```java
copyDataBase("app.db");
```
- src/java/org.apache.ibatis.parsing.XPathParser.java
```java
factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
```
