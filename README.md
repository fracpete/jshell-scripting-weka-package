# jshell-scripting-weka-package
Weka package offering scripting via [jshell](https://docs.oracle.com/javase/9/jshell/) from the GUI chooser, using the [jshell-scripting](https://github.com/fracpete/jshell-scripting) library. 

Under the hood, the *jshell* executable is started with a custom classpath compiled from the current JVM, executing the current content of the editor saved as a temporary script file.

The package requires you to start Weka with Java 9 or later.


## Examples

### J48

The following code loads the UCI dataset *anneal*, cross-validates J48 on it
and outputs the summary statistics.

```java
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import java.util.Random;

Instances data = DataSource.read("/some/where/anneal.arff");
data.setClassIndex(data.numAttributes() - 1);

J48 cls = new J48();
Evaluation eval = new Evaluation(data);
eval.crossValidateModel(cls, data, 10, new Random(1));
System.out.println(eval.toSummaryString());
```

### M5P

In this case, M5P is cross-validated on the UCI dataset *bolts*:

```java
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.M5P;
import weka.classifiers.Evaluation;
import java.util.Random;

Instances data = DataSource.read("/some/where/bolts.arff");
data.setClassIndex(data.numAttributes() - 1);

M5P cls = new M5P();
Evaluation eval = new Evaluation(data);
eval.crossValidateModel(cls, data, 10, new Random(1));
System.out.println(eval.toSummaryString());
```


### LibSVM (package)

Since *jshell* is a separate process with its own classpath, classes within 
packages are not visible directly. For getting access to packages, you need to 
load all Weka packages using `WekaPackageManager.loadPackages(false, false, false)`
and then instantiate classes via the `Utils.forName` method. Setting options is
possible via the `setOptions` method.

In the following example, the LibSVM classifier (from the *LibSVM* package) is 
instantiated and then cross-validated on the UCI dataset *anneal*:


```java
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.OptionHandler;
import weka.core.Utils;
import weka.core.WekaPackageManager;
import weka.classifiers.Evaluation;
import weka.classifiers.Classifier;
import java.util.Random;

WekaPackageManager.loadPackages(false, false, false);

Instances data = DataSource.read("/some/where/anneal.arff");
data.setClassIndex(data.numAttributes() - 1);

Classifier cls = (Classifier) Utils.forName(Classifier.class, "weka.classifiers.functions.LibSVM", new String[0]);
((OptionHandler) cls).setOptions(new String[]{"-K", "2"});
Evaluation eval = new Evaluation(data);
eval.crossValidateModel(cls, data, 10, new Random(1));
System.out.println(eval.toSummaryString());
```


## Releases

Click on one of the following links to download the corresponding Weka package:

* [2018.7.2](https://github.com/fracpete/jshell-scripting-weka-package/releases/download/v2018.7.2/mxexpression-2018.7.2.zip)


## Maven

Add the following dependency in your `pom.xml` to include the package:

```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>jshell-scripting-weka-package</artifactId>
      <version>2018.7.2</version>
      <type>jar</type>
      <exclusions>
        <exclusion>
          <groupId>nz.ac.waikato.cms.weka</groupId>
          <artifactId>weka-dev</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
```

