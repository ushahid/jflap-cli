# jflap-cli
A command line utility for the JFLAP software. Can be used for autograding or embedding in other applications.


## Build
This project can be built using gradle. First, clone this repo:

```
git clone https://github.com/ushahid/jflap-cli
```

Run gradle build

```
gradlew build
```

The JAR file with all dependencies is bulit in `app/build/libs/app-all.jar`.

Rename it to jflapcli.jar and run it as:

```
java -jar jflapcli.jar runonce FILEPATH test_string
```

Where `FILEPATH` is a valid JFLAP file containg FSM/PDA/TM or Grammar. It should print out true if the string is accepted/generated or false otherwise.

Use the following command to generate the help messsage:
```
java -jar jflapcli.jar help
```

## Features
Curently it supports testing single input (runonce subcommand) for FSM/PDA/TM/Mealy/Moore and Grammars.


## ToDO
- Add support for Regex
- Add support for multiple inputs


## Inspired by
https://github.com/citiususc/jflap-lib


## JFLAP 7.1 license
This project contains the original JFLAP 7.1 source code with minor modications in jflap-core subdirectory. This code is available under the following original license:

    JFLAP 7.1 LICENSE

    Susan H. Rodger
    Computer Science Department
    Duke University
    July 27, 2018

    Duke University students contributing to JFLAP source include: Thomas Finley,
    Ryan Cavalcante, Stephen Reading, Bart Bressler, Jinghui Lim, Chris Morgan,
    Kyung Min (Jason) Lee, Jonathan Su, Henry Qin and Jay Patel.

    Copyright (c) 2002-2018.
    All rights reserved.


    I)  You are allowed distribute unmodified copies of JFLAP under the following two conditions:
        1) You must include a copy of this license text.
        2) You cannot charge a fee for any product that includes any part of JFLAP, in source or binary form.


    II) You are allowed to distribute modified copies of JFLAP under the following conditions:
        1) You must include a copy of this license text.
        2) You cannot charge a fee for any product that includes any part of your modified JFLAP, in source or binary form.
        3) If you made the changes yourself, you must clearly describe how to contact you.
           When the maintainer asks you (in any way) for a copy of the modified JFLAP you distributed, you
           must make your changes, including source code, available to the maintainer without fee.  
           The maintainer reserves the right to include your changes in the official version of JFLAP. 
           The current maintainer is Susan Rodger . If this changes, it will be announced at www.jflap.org.


    The name of the author may not be used to
    endorse or promote products derived from this software without
    specific prior written permission.

    THIS SOFTWARE IS PROVIDED ``AS IS'' AND WITHOUT ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
    WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.

The code for CLI (in `app` sub-directory) is released under the MIT license.
