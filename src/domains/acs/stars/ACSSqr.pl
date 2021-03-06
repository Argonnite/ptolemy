defcorona {
    name { Sqr }
    domain { ACS }
    desc { Functionally this is a multiplier, the user should ensure that both inputs are identical.  This multiplier is specialized for wordlength analysis by assuming that the inputs are from the same source }
    version { @(#)ACSSqr.pl	1.0 10/26/00}
    author { J. Ramanathan }
    copyright {
Copyright (c) 1998 The Regents of the University of California.
All rights reserved.
See the file $PTOLEMY/copyright for copyright notice,
limitation of liability, and disclaimer of warranty provisions.
    }
    location { ACS main library }
    input {
        name { input1 }
        type { float }
    }
    input {
        name { input2 }
        type { float }
    }
    output {
        name { output }
        type { float }
    }
}
