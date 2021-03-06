# Rosetta Euler

An attempt at a [chrestomathy](http://en.wikipedia.org/wiki/Chrestomathy) of solutions to problems from [Project Euler](http://projecteuler.net/). All included programs print out their result to standard output (when possible and applicable) and exit.

* [Ada](#ada)
* [Algol 68](#algol-68)
* [BCPL](#bcpl)
* [C](#c)
* [C++](#c-1)
* [C&#35;](#c-2)
* [COBOL](#cobol)
* [Common Lisp](#common-lips)
* [Clojure](#clojure)
* [Crystal](#crystal)
* [D](#d)
* [Eiffel](#eiffel)
* [Elixir](#elixir)
* [Erlang](#erlang)
* [Fortran](#fortran)
* [F&#35;](#f)
* [Go](#go)
* [Groovy](#groovy)
* [Haskell](#haskell)
* [Io](#io)
* [Java](#java)
* [JavaScript](#javascript)
* [Julia](#julia)
* [K](#k)
* [Lua](#lua)
* [Nim](#nim)
* [Objective-C](#objective-c)
* [OCaml](#ocaml)
* [Pascal](#pascal)
* [Perl](#perl)
* [Prolog](#prolog)
* [Python](#python)
* [Ruby](#ruby)
* [Rust](#rust)
* [Scala](#scala)
* [Scheme](#scheme)
* [Simula](#simula)
* [Swift](#swift)
* [x86-64 Assembly](#x86-64-assembly)

## Initial Setup on All Systems

Initialize all submodules.

    $ git submodule update --init --recursive

## Initial Setup on OSX

Install [Xcode](https://developer.apple.com/xcode/).

Install the Command Line Tools in Xcode (Preferences > Downloads > Install button next to Command Line Tools).

Install [Homebrew](http://brew.sh/).

## Rules

I've imposed a few rules on myself for these problems:

* No third party libraries except for Bignum libraries in languages that do no have them as part of the standard library.
* No relying on implementation or compiler dependent behavior except to overcome memory or stack depth limitations.
* Each language's solutions should have formatting that is as close to its community's most widely followed idiomatic style as possible if one exists.
* When applicable, all Makefiles should contain everything needed to compile its solution.
* In languages without Unicode encoded strings assume ASCII.
* In languages with Unicode encoded strings pretend UTF-8 is ASCII.

## Tests

The test suite can be run with `mix test`. Currently only some languages are supported. Eventually every language will have test coverage. For compiled languages the tests will attempt to compile the solution and then run the resulting executable. For interpreted languages (or languages like Elixir where the solutions are written as scripts rather than as complete applications) the tests will attempt to run the solution through the interpreter. This is also a good way of checking ot make sure that your environment is set up correctly.

All tests are written with [ExUnit](http://elixir-lang.org/docs/stable/ex_unit/ExUnit.html) and are located in `test/rosetta_euler`. Each language has a module for its tests. The `rosetta_euler_tests` macro provides an easy way of running a whole series of tests. It expects a range object and a block which contains the test code.

## Languages

### Ada

[Libre: Free Software and Open-Source Development with Ada](http://libre.adacore.com/)

#### Target Version

    $ gnat
    GNAT GPL 2016 (20160515-49)
    Copyright 1996-2016, Free Software Foundation, Inc.

#### Additional Setup on OSX

[Download GNAT GPL](http://libre.adacore.com/download/configurations).

* Next to "Select your platform:" select "x86-64 Mac OS X (64 bits)" and "GNAT GPL 2016".
* Click "GNAT Ada GPL 2016".
* Check "gnat-gpl-2016-x86_64-darwin-bin.tar.gz".
* Click "Download Selected Files".

Go to your Downloads directory.

    $ cd ~/Downloads

Extract the gzip archive.

    $ tar -xvzf gnat-gpl-2016-x86_64-darwin-bin.tar.gz

Go to the directory containing the gzip archive contents.

    $ cd gnat-gpl-2016-x86_64-darwin-bin

Run the install script.

    $ ./doinstall

Answer the install script's questions. If you keep pressing enter and answering "Y" it will install GNAT in `/usr/local/gnat`.

Add `/usr/local/gnat/bin` to your $PATH. For example, in your `~/.bashrc` or `~/.zshrc` add:

    export PATH="/usr/local/gnat/bin:$PATH"

Open a new terminal tab/window or reload your `~/.bashrc` or `~/.zshrc`.

Remove the gzip archive and the extracted files.

    $ cd ~/Downloads
    $ rm -rf gnat-gpl-2016-x86_64-darwin-bin.tar.gz gnat-gpl-2016-x86_64-darwin-bin

#### Building

    $ gnatmake euler.adb

#### Running

    $ ./euler

### Algol 68

[Algol 68 Genie](http://jmvdveer.home.xs4all.nl/)

#### Target Version

    $ a68g --version
    Algol 68 Genie 2.8.3
    Copyright 2016 Marcel van der Veer <algol68g@xs4all.nl>.

    This is free software covered by the GNU General Public License.
    There is ABSOLUTELY NO WARRANTY for Algol 68 Genie;
    not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU General Public License for more details.

    Please report bugs to Marcel van der Veer <algol68g@xs4all.nl>.

    Compilation is supported.
    Parallel-clause is supported.
    Curses is supported.
    Regular expressions are supported.
    TCP/IP is supported.
    GNU libplot is not supported.
    GNU Scientific Library is not supported.
    PostgreSQL is not supported.

#### Additional Setup on OSX

Install the `algol68g` formula via Homebrew.

    $ brew install algol68g

#### Running

    $ a68g 001.a68

### BCPL

[BCPL](http://www.cl.cam.ac.uk/~mr10/BCPL.html)

#### Target Version

    $ cintsys
    BCPL 32-bit Cintcode System (21 Oct 2015)

#### Additional Setup on OSX

Download the BCPL source code.

    $ wget http://www.cl.cam.ac.uk/users/mr/BCPL/bcpl.tgz

Unpack the BCPL source code.

    $ tar -xf bcpl.tgz

Go to the BCPL source code directory.

    $ cd BCPL/cintcode

Open up the `Makefile` in your preferred text editor and uncomment lines 190 and 191 so that they look like this:

    CC = gcc -O4 -m32 -DforMacOSX
    ENDER = litender

Set the `BCPLROOT`, `PATH`, `BCPLPATH`, and `BCPLHDRS` environment variables. **Note: This step will need to be done every time you intend to use BCPL. Alternatively you can set this in your shell's initialization file.** The below commands assume you're still in the `BCPL/cintcode` directory.

    $ EXPORT BCPLROOT=`pwd`
    $ EXPORT PATH=$PATH:$BCPLROOT/bin
    $ EXPORT BCPLPATH=$BCPLROOT/cin
    $ EXPORT BCPLPATH=$BCPLROOT/g

Run the make clean command.

    $ make clean

Run the make command.

    $ make

#### Running

**See above note about environment variables.**

    $ cintsys

    BCPL 32-bit Cintcode System (21 Oct 2015)
    0.000> c b euler
    bcpl euler.b to euler hdrs BCPLHDRS t32

    BCPL (10 Oct 2014) with simple floating point
    Code size =    80 bytes of 32-bit little ender Cintcode
    0.027> euler

### C

[ISO C Working Group](http://www.open-std.org/jtc1/sc22/wg14/)

[Clang](http://clang.llvm.org/)

#### Target Version

    $ clang --version
    Apple LLVM version 6.0 (clang-600.0.56) (based on LLVM 3.5svn)
    Target: x86_64-apple-darwin14.0.0
    Thread model: posix

#### Additional Setup on OSX

Some solutions require [The GNU Multiple Precision Arithmetic Library](http://gmplib.org/) for big numbers.

Install the `gmp` formula via Homebrew.

    $ brew install gmp

#### Building

    $ make 001

#### Running

    $ ./001

### C++

[ISO C++ Working Group](http://www.open-std.org/JTC1/SC22/WG21/)

[Clang](http://clang.llvm.org/)

#### Target Version

    $ clang --version
    Apple LLVM version 6.0 (clang-600.0.56) (based on LLVM 3.5svn)
    Target: x86_64-apple-darwin14.0.0
    Thread model: posix

#### Additional Setup on OSX

None.

#### Building

    $ make 001

#### Running

    $ ./001

### C&#35;

[Visual C&#35; Resources](http://msdn.microsoft.com/en-us/vstudio/hh341490.aspx)

[Mono](http://www.mono-project.com/)

#### Target Version

    $ mcs --version
    Mono C# compiler version 4.2.3.0

#### Additional Setup on OSX

Download and install the [Mono MDK](http://www.mono-project.com/download/).

#### Building

    $ mcs 001.cs

#### Running

    $ mono 001.exe

### COBOL

[GnuCOBOL](http://sourceforge.net/projects/open-cobol/)

#### Target Version

    $ cobc --version
    cobc (GNU Cobol) 1.1.0
    Copyright (C) 2001,2002,2003,2004,2005,2006,2007 Keisuke Nishida
    Copyright (C) 2006-2012 Roger While
    This is free software; see the source for copying conditions.  There is NO
    warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    Built     Jan 08 2015 12:54:42
    Packaged  Jan 20 2014 07:40:53 UTC
    C version "4.9.2"

#### Additional Setup on OSX

Install the `gnu-cobol` formula via Homebrew.

    $ brew install gnu-coboll

#### Building

    $ cobc -x 001.cob

#### Running

    $ ./001

### Common Lisp

[GNU CLISP](http://www.clisp.org/)

#### Target Version

    $ clisp --version
    GNU CLISP 2.49 (2010-07-07) (built on - [-.-.-.-])
    Software: GNU C 4.2.1 (Based on Apple Inc. build 5658) (LLVM build 2335.15.00)
    /usr/bin/llvm-gcc -m64 -w -pipe -march=core2 -msse4 -W -Wswitch -Wcomment -Wpointer-arith -Wimplicit -Wreturn-type -Wmissing-declarations -Wno-sign-compare -Wno-format-nonliteral -O -falign-functions=4 -DUNIX_BINARY_DISTRIB -DENABLE_UNICODE -DDYNAMIC_MODULES -DNO_GETTEXT -I.  -w -pipe -march=core2 -msse4 -L/usr/local/Cellar/readline/6.2.2/lib  -lreadline -lncurses  -liconv -lsigsegv libgnu_cl.a -L/usr/X11/lib -R/usr/X11/lib
    SAFETY=0 HEAPCODES STANDARD_HEAPCODES WIDE_HARD GENERATIONAL_GC SPVW_BLOCKS SPVW_MIXED TRIVIALMAP_MEMORY
    libsigsegv 2.10
    libiconv 1.11
    libreadline 6.2
    Features: (REGEXP SYSCALLS I18N LOOP COMPILER CLOS MOP CLISP ANSI-CL COMMON-LISP LISP=CL INTERPRETER SOCKETS GENERIC-STREAMS LOGICAL-PATHNAMES SCREEN UNICODE BASE-CHAR=CHARACTER WORD-SIZE=64 UNIX MACOS)
    C Modules: (clisp i18n syscalls regexp)
    Installation directory: /usr/local/Cellar/clisp/2.49/lib/clisp-2.49/
    User language: ENGLISH
    Machine: X86_64 (X86_64) - [-.-.-.-]

#### Additional Setup on OSX

Install the `clisp` formula via Homebrew.

    $ brew install clisp

#### Running

    $ clisp 001.lisp

### Clojure

[Clojure](http://clojure.org/)

[Leiningen](http://leiningen.org/)

#### Target Version

    $ lein version
    Leiningen 2.5.0 on Java 1.6.0_65 Java HotSpot(TM) 64-Bit Server VM

    $ lein repl
    nREPL server started on port 49531 on host 127.0.0.1 - nrepl://127.0.0.1:49531
    REPL-y 0.3.5, nREPL 0.2.6
    Clojure 1.6.0
    Java HotSpot(TM) 64-Bit Server VM 1.6.0_65-b14-466.1-11M4716

#### Additional Setup on OSX

Install the `leiningen` formula via Homebrew.

    $ brew install leiningen

#### Running

    $ lein run

### Crystal

[Crystal](http://crystal-lang.org/)

#### Target Version

    $ crystal --version
    Crystal 0.15.0 (Fri Apr  1 17:57:09 UTC 2016)

#### Additional Setup on OSX

Install the `crystal-lang` formula via Homebrew.

    $ brew install crystal-lang

#### Running

    $ crystal 001.cr

### D

[D Programming Language](http://dlang.org/)

#### Target Version

    $ dmd
    DMD64 D Compiler v2.066
    Copyright (c) 1999-2014 by Digital Mars written by Walter Bright
    Documentation: http://dlang.org/

#### Additional Setup on OSX

Install the `dmd` formula via Homebrew.

    $ brew install dmd

#### Building

    $ dmd 001.d

#### Running

    $ ./001

### Eiffel

[Eiffel Software](https://www.eiffel.com/)

#### Target Version

    $ ec -version
    ISE EiffelStudio version 14.05.9.5417 GPL Edition - macosx-x86-64

#### Additional Setup on OSX

Tap the `homebrew/x11` keg.

    $ brew tap homebrew/x11

Install the `eiffelstudio` formula via Homebrew.

    $ brew install eiffelstudio

#### Building

    $ ec euler.e

You may need to chmod the resulting executable so that it has execute permissions.

#### Running

    $ ./euler

### Elixir

[Elixir](http://elixir-lang.org/)

#### Target Version

    $ elixir --version
    Elixir 1.0.2

#### Additional Setup on OSX

Install the `erlang` formula via Homebrew.

    $ brew install erlang

Install the `elixir` formula via Homebrew.

    $ brew install elixir

#### Running

    $ elixir 001.exs

### Erlang

[Erlang Programming Language](http://www.erlang.org/)

#### Target Version

    $ erl
    Erlang/OTP 17 [erts-6.3] [source] [64-bit] [smp:8:8] [async-threads:10] [hipe] [kernel-poll:false] [dtrace]

    Eshell V6.3  (abort with ^G)

#### Additional Setup on OSX

Install the `erlang` formula via Homebrew.

    $ brew install erlang

#### Running

    $ ./euler.erl

### Fortran

[IOS/IEC JTC1/SC22/WG5 (Fortran)](http://www.nag.co.uk/sc22wg5/)

[GNU Fortran](http://gcc.gnu.org/fortran/)

#### Target Version

    $ gfortran --version
    GNU Fortran (Homebrew gcc 4.9.2_1) 4.9.2
    Copyright (C) 2014 Free Software Foundation, Inc.

    GNU Fortran comes with NO WARRANTY, to the extent permitted by law.
    You may redistribute copies of GNU Fortran
    under the terms of the GNU General Public License.
    For more information about these matters, see the file named COPYING

#### Additional Setup on OSX

Install the `gcc` formula via Homebrew.

    $ brew install gcc

#### Building

    $ make 001

#### Running

    $ ./001

### F&#35;

[The F&#35; Software Foundation](http://fsharp.org/)

[Visual F&#35; Resources](http://msdn.microsoft.com/en-us/vstudio/hh388569.aspx)

[Mono](http://www.mono-project.com/)

#### Target Version

    $ fsharpc
    F# Compiler for F# 4.0 (Open Source Edition)
    Freely distributed under the Apache 2.0 Open Source License

#### Additional Setup on OSX

Download and install the [Mono MDK](http://www.mono-project.com/download/).

#### Building

    $ fsharpc 001.fs

#### Running

    $ mono 001.exe

### Go

[The Go Programming Language](http://golang.org/)

#### Target Version

    $ go version
    go version go1.4 darwin/amd64

#### Additional Setup on OSX

Install the `go` formula via Homebrew.

    $ brew install go

Create a directory for your `$GOPATH`

    $ mkdir ~/golang

Ensure the following is in your `.bashrc` or `.zshrc`.

    export GOPATH="$HOME/golang"

Either open up a new terminal or run the following:

    $ export GOPATH="$HOME/golang"

#### Running

    $ go run 001.go

### Groovy

[Groovy](http://groovy.codehaus.org/)

#### Target Version

    $ groovy -v
    Groovy Version: 2.3.9 JVM: 1.6.0_65 Vendor: Apple Inc. OS: Mac OS X

#### Additional Setup on OSX

Install the `groovy` formula via Homebrew.

    $ brew install groovy

#### Running

    $ groovy 001.groovy

### Haskell

[The Haskell Programming Language](http://www.haskell.org/haskellwiki/Haskell)

#### Target Version

    $ ghc --version
    The Glorious Glasgow Haskell Compilation System, version 7.8.3

    $ cabal --version
    cabal-install version 1.18.0.5
    using version 1.18.1.4 of the Cabal library

#### Additional Setup on OSX

Download and install [The Haskell Platform](https://www.haskell.org/platform/mac.html).

Add `$HOME/.cabal/bin` to your PATH.

Update cabal.

    $ cabal update

If `cabal update` says you need to, update `cabal-install`

    $ cabal install cabal-install

#### Building

Create a Cabal sandbox if you haven't already.

    $ cabal sandbox init

Compile the project and install it into the sandbox.

    $ cabal install -j

#### Running

    $ .cabal-sandbox/bin/euler

### Io

[Io](http://iolanguage.org/)

#### Target Version

    $ io --version
    Io Programming Language, v. 20110905

#### Additional Setup on OSX

Io's installer doesn't seem to play nicely with non-system Pythons. If you're using `pyenv` (or anything similar) set the current Python to the OSX system Python.

    $ pyenv global system

Install the `io` formula via Homebrew (the `--use-clang` option might not be necessary).

    $ brew install io --use-clang

Reset your Python.

    $ pyenv global 2.7.5

#### Running

    $ io 001.io

### Java

[Oracle Technology Network for Java Developers](http://www.oracle.com/technetwork/java/index.html)

#### Target Version

    $ java -version
    java version "1.6.0_65"
    Java(TM) SE Runtime Environment (build 1.6.0_65-b14-466.1-11M4716)
    Java HotSpot(TM) 64-Bit Server VM (build 20.65-b04-466.1, mixed mode)

#### Additional Setup on OSX

Most likely none.

#### Building

    $ javac Euler.java

#### Running

    $ java Euler

### JavaScript

[ECMAScript Language Specification](http://www.ecma-international.org/ecma-262/5.1/)

[node.js](http://nodejs.org/)

#### Target Version

    $ node --version
    v0.10.35

#### Additional Setup on OSX

Install the `node` formula via Homebrew.

    $ brew install node

#### Running

    $ node 001.js

### Julia

[The Julia Language](http://julialang.org/)

#### Target Version

    $ julia -v
    julia version 0.3.4

#### Additional Setup on OSX

The following instructions are from the readme at [staticfloat/homebrew-julia](https://github.com/staticfloat/homebrew-julia). Please verify they are the same before proceeding.

Tap the `staticfloat/julia` keg.

    $ brew tap staticfloat/julia

Install the `julia` formula via Homebrew.

    $ brew install julia

#### Running

    $ julia 001.jl

### K

[Kona](https://github.com/kevinlawler/kona)

#### Target Version

Taken from [k.c](https://github.com/kevinlawler/kona/blob/5daf44308bd8a25c42bbea5665f480b0be42345d/src/k.c).

    //64-bit single-threaded implementation of K3.2.  Version is Kona 3.2.0

#### Additional Setup on OSX

The following instructions are from the readme at [kevinlawler/kona](https://github.com/kevinlawler/kona). Please verify they are the same before proceeding.

Clone the Kona respository.

    $ git clone https://github.com/kevinlawler/kona.git

Go to the Kona source directory.

    $ cd kona

Run the `make` command.

    $ make

Run the `make install` command.

    $ make install

#### Running

    $ k 001.k

### Lua

[The Programming Language Lua](http://www.lua.org/)

#### Target Version

    $ lua -v
    Lua 5.2.3  Copyright (C) 1994-2013 Lua.org, PUC-Rio

#### Additional Setup on OSX

Install the `lua` formula via Homebrew.

    $ brew install lua

#### Running

    $ lua 001.lua

### Nim

[Nim Programming Language](http://nim-lang.org/)

#### Target Version

    $ nim --version
    Nim Compiler Version 0.10.2 (2014-12-29) [MacOSX: amd64]
    Copyright (c) 2006-2014 by Andreas Rumpf

    active boot switches: -d:release

#### Additional Setup on OSX

Install the `nim` formula via Homebrew.

    $ brew install nim

#### Building

    $ nim compile euler

#### Running

    $ ./euler

### Objective-C

[Mac Developer Library](http://developer.apple.com/library/mac/navigation/)

[Clang](http://clang.llvm.org/)

#### Target Version

    $ clang --version
    Apple LLVM version 6.0 (clang-600.0.56) (based on LLVM 3.5svn)
    Target: x86_64-apple-darwin14.0.0
    Thread model: posix

#### Additional Setup on OSX

None.

#### Building

    $ make all

#### Running

    $ ./001

### OCaml

[OCaml](http://ocaml.org/)

#### Target Version

    $ ocaml -version
    The OCaml toplevel, version 4.02.1

#### Additional Setup on OSX

Install the `ocaml` formula via Homebrew.

    $ brew install ocaml

#### Running

    $ ocaml 001.ml

### Pascal

[Free Pascal](http://www.freepascal.org/)

#### Target Version

    $ fpc
    Free Pascal Compiler version 3.0.0 [2016/02/18] for x86_64
    Copyright (c) 1993-2015 by Florian Klaempfl and others

#### Additional Setup on OSX

Install the `fpc` formula via Homebrew.

    $ brew install fpc

#### Building

    $ fpc 001.pp

#### Running

    $ ./001

### Perl

[The Perl Programming Language](http://www.perl.org/)

#### Target Version

    $ perl -v

    This is perl 5, version 18, subversion 2 (v5.18.2) built for darwin-thread-multi-2level
    (with 2 registered patches, see perl -V for more detail)

    Copyright 1987-2013, Larry Wall

    Perl may be copied only under the terms of either the Artistic License or the
    GNU General Public License, which may be found in the Perl 5 source kit.

    Complete documentation for Perl, including FAQ lists, should be found on
    this system using "man perl" or "perldoc perl".  If you have access to the
    Internet, point your browser at http://www.perl.org/, the Perl Home Page.

#### Additional Setup on OSX

None. This is the default version of Perl on OSX 10.10.

#### Running

    $ perl 001.pl

### Prolog

[The GNU Prolog web site](http://gprolog.univ-paris1.fr/)

#### Target Version

    $ gplc --version
    Prolog compiler (GNU Prolog) 1.4.4
    By Daniel Diaz
    Copyright (C) 1999-2013 Daniel Diaz

    GNU Prolog comes with ABSOLUTELY NO WARRANTY.
    This is free software; see the source or the file
    named COPYING for copying conditions.

#### Additional Setup on OSX

Install the `gnu-prolog` formula via Homebrew.

    $ brew install gnu-prolog

#### Building

    $ gplc 001.pro

For some solutions (in particular #4) it may be necessary to increase the global and local stack sizes. This can be accomplished with the following environment variable arguments:

    $ GLOBALSZ=300000 LOCALSZ=60000 gplc 001.pro

#### Running

    $ ./001

The same global and local stack size environment variable arguments can be used for the resulting executable as well:

    $ GLOBALSZ=300000 LOCALSZ=60000 ./001

### Python

[Python Programming Language](http://www.python.org/)

#### Target Version

    $ python --version
    Python 2.7.5

#### Additional Setup on OSX

Install the `pyenv` formula via Homebrew.

    $ brew install pyenv

Ensure the following is in your `.bashrc` or `.zshrc`.

    if which pyenv > /dev/null; then eval "$(pyenv init -)"; fi

Install Python 2.7.5.

    $ pyenv install 2.7.5

Set the default Python.

    $ pyenv global 2.7.5

#### Running

    $ python 001.py

### Ruby

[Ruby Programming Language](https://www.ruby-lang.org/en/)

#### Target Version

    $ ruby -v
    ruby 2.2.0p0 (2014-12-25 revision 49005) [x86_64-darwin14]

#### Additional Setup on OSX

Install [RVM](https://rvm.io/).

    $ curl -L https://get.rvm.io | bash

Ensure the following is in your `.bashrc` or `.zshrc`.

    [[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm"

Either open up a new terminal or run the following:

    $ source ~/.rvm/scripts/rvm

Force RVM to use Homebrew for downloading necessary packages.

    $ rvm autolibs homebrew

Install `2.2.0`.

    $ rvm install 2.2.0

Set the default Ruby.

    $ rvm --default use 2.2.0

#### Running

    $ ruby 001.rb

### Rust

[The Rust Programming Language](http://www.rust-lang.org/)

#### Target Version

    $ rustc --version
    rustc 1.11.0

#### Additional Setup on OSX

Install the `rust` formula via Homebrew.

    $ brew install rust

#### Building

    $ rustc 001.rs

#### Running

    $ ./001

### Scala

[The Scala Programming Language](http://www.scala-lang.org/)

#### Target Version

    $ scala -version
    Scala code runner version 2.11.1 -- Copyright 2002-2013, LAMP/EPFL

#### Additional Setup on OSX

Install the `scala` formula via Homebrew.

    $ brew install scala

#### Running

    $ scala 001.scala

### Scheme

[MIT/GNU Scheme](http://www.gnu.org/software/mit-scheme/)

#### Target Version

    $ scheme --version
    MIT/GNU Scheme microcode 15.3
    Copyright (C) 2014 Massachusetts Institute of Technology
    This is free software; see the source for copying conditions. There is NO warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

    Image saved on Thursday November 27, 2014 at 10:21:15 AM
    Release 9.2 || Microcode 15.3 || Runtime 15.7 || SF 4.41 || LIAR/C 4.118 || Edwin 3.116

    Moriturus te saluto.

#### Additional Setup on OSX

Install the `mit-scheme` formula via Homebrew.

    $ brew install homebrew/x11/mit-scheme

#### Running

    $ scheme --quiet --load 001.scm

### Simula

[GNU Cim](http://simula67.at.ifi.uio.no/cim.shtml)

#### Target Version

    $ cim --version
    -i686-apple-darwin14.3.0

#### Additional Setup on OSX

Download the Cim source code.

    $ wget http://simula67.at.ifi.uio.no/Cim/cim-3.37.tar.gz

Unpack the Cim source code.

    $ tar -xf cim-3.37.tar.gz

Go to the Cim source code directory.

    $ cd cim-3.37

Run the configure command (note: I had to add an additional flag to make it work without errors).

    $ CFLAGS='-O0 -m32 -Wno-return-type' ./configure

Run the make command.

    $ make

Run the make install command.

    $ make install

#### Building

    $ make

#### Running

    $ ./001

### Swift

[Swift Overview](https://developer.apple.com/swift/)

#### Target Version

    $ swift --version
    Apple Swift version 1.2 (swiftlang-602.0.49.3 clang-clang-602.0.49)
    Target: x86_64-apple-darwin14.3.0

#### Additional Setup on OSX

None.

#### Running

    $ swift 001.swift

### x86-64 Assembly

[OSX Assembly Reference](https://developer.apple.com/library/mac/documentation/DeveloperTools/Reference/Assembler/000-Introduction/introduction.html)

[Clang](http://clang.llvm.org/)

#### Target Version

    $ clang --version
    Apple LLVM version 6.0 (clang-600.0.56) (based on LLVM 3.5svn)
    Target: x86_64-apple-darwin14.0.0
    Thread model: posix

#### Additional Setup on OSX

None.

**Note: By its nature assembly is very architecture specific. The general logic should remain the same across different platforms, but it's entirely possible significant changes might be required depending on your setup.**

#### C to Assembly

The examples of assembly in this project are taken entirely or mostly from Clang's assembly output from the C examples.

    $ clang -S -fno-asynchronous-unwind-tables 001.c

Clang can output either AT&T or Intel assembly, but as far as I can figure it only supports AT&T syntax assembly for input. To see the Intel syntax assembly add `-mllvm --x86-asm-syntax=intel` after the `-S` option.

#### Building

    $ clang 001.s -o 001

#### Running

    $ ./001
