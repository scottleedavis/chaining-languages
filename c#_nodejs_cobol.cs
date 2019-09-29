using System;
using System.Threading.Tasks;
using EdgeJs;

class Program
{
    public static async Task Start()
    {
        var func = Edge.Func(@"
            const Cobol = require("cobol");

            return function (data, callback) {
				Cobol(function () {/*
				                    IDENTIFICATION DIVISION.
									PROGRAM-ID. HELLO-WORLD.
									PROCEDURE DIVISION.
									DISPLAY 'Hello, world'.
									STOP RUN.
				                   */}, {
				                       compileargs:{
				                           free: true
				                       }
				                   }, function (err, data) {
               		callback(null, err || data);
				});
            }
        ");

        Console.WriteLine(await func());
    }

    static void Main(string[] args)
    {
        Start().Wait();
    }
}
