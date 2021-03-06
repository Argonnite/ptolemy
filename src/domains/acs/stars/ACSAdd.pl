defcorona {
    name { Add }
    domain { ACS }
    desc { Output the sum of the inputs. }
    version { @(#)ACSAdd.pl	1.5 09/08/99}
    author { James Lundblad }
    copyright {
Copyright (c) 1998 The Regents of the University of California.
All rights reserved.
See the file $PTOLEMY/copyright for copyright notice,
limitation of liability, and disclaimer of warranty provisions.
    }
    location { ACS main library }
    inmulti {
        name { input }
        type { float }
    }
    output {
        name { output }
        type { float }
    }
}
