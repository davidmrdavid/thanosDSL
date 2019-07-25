# thanos



This is the initial skeleton for a trufflecuda Truffle language.

To build the language and the unit tests:
```
mx build
```

To create eclipse, intellij, netbeans projects:
```
mx ideinit
```

To run unit tests:
```
mx unittest org.thanos
```

To use the thanos language from python:
```
mx --dynamicimports graalpython --cp-sfx <path-to-thanos>/mxbuild/dists/jdk1.8/thanos.jar python --polyglot
...
>>> import polyglot
>>> polyglot.eval(language="thanos",string="asdf")
Create Context for Thanos
1
>>> polyglot.eval(language="thanos",string="asdf")
1
```
