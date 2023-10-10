Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.

Examples
* With input "10.0.0.0", "10.0.0.50"  => return   50 
* With input "10.0.0.0", "10.0.1.0"   => return  256 
* With input "20.0.0.10", "20.0.1.0"  => return  246

Tests

const strictEqual = require('chai').assert.strictEqual;

function doTest (start, end, expected) {
  const actual = ipsBetween(start, end);
  strictEqual(actual, expected, `for start = ${start}, end = ${end}\n`);
}

    describe("Tests", () => {

    it("sample tests", () => {

        doTest("150.0.0.0", "150.0.0.1", 1);

        doTest("10.0.0.0", "10.0.0.50", 50);

        doTest("20.0.0.10", "20.0.1.0", 246);

        doTest("10.11.12.13", "10.11.13.0", 243);

        doTest("160.0.0.0", "160.0.1.0", 256);

        doTest("170.0.0.0", "170.1.0.0", 65536);

        doTest("50.0.0.0", "50.1.1.1", 65793);

        doTest("180.0.0.0", "181.0.0.0", 16777216);

        doTest("1.2.3.4", "5.6.7.8", 67372036);

        doTest("0.0.0.0", "255.255.255.255", 2 ** 32 - 1);
        
        });
    });