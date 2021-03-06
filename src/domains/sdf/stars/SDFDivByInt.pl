defstar {
	name { DivByInt }
	domain { SDF }
	desc {
This is an amplifier.  The integer output is the integer input
divided by the integer "divisor" (default 1).  Truncated integer
division is used.
	}
	version { @(#)SDFDivByInt.pl	1.2	4/26/96 }
	author { Brian L. Evans }
	copyright {
Copyright (c) 1990-1996 The Regents of the University of California.
All rights reserved.
See the file $PTOLEMY/copyright for copyright notice,
limitation of liability, and disclaimer of warranty provisions.
	}
	location { SDF main library }
	input {
		name { input }
		type { int }
	}
	output {
		name { output }
		type { int }
	}
	defstate {
		name { divisor }
		type { int }
		default { "2" }
		desc { Inverse of the gain of the amplifier. }
	}
	setup {
		if ( int(divisor) == 0 ) {
		     Error::abortRun(*this, "divisor cannot be zero");
		}
	}
	go {
		output%0 << int(input%0)/int(divisor);
	}
}
