del RationalTest.class
javac -cp C:\APTFall2014Amy\lab4\junit-4.11.jar;. RationalTest.java Rational.java
java -cp C:\APTFall2014Amy\lab4\junit-4.11.jar;. RationalTest
java -XX:-UseSplitVerifier -cp C:\APTFall2014Amy\lab4\emma.jar;C:\APTFall2014Amy\lab4\junit-4.11.jar;. emmarun -sp . -r html -cp C:\APTFall2014Amy\lab4\junit-4.11.jar;. RationalTest