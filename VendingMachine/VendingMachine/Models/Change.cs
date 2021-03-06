﻿using System;
namespace VendingMachine.Models
{
    public class Change
    {
        public decimal Dollar { set; get; }
        public decimal Quarter { set; get; }
        public decimal Dime { set; get; }
        public decimal Nickel { set; get; }
        public decimal Penny { set; get; }

        public Change()
        {

        }
        public Change(decimal dollar, decimal quarter, decimal dime, decimal nickel, decimal penny)
        {
            Dollar = dollar;
            Quarter = quarter;
            Dime = dime;
            Nickel = nickel;
            Penny = penny; 
        }

        public override string ToString()
        {
            Console.WriteLine("Your changes are: ");
            return ("Dollar " + Dollar + "\n"+ "Quarter " + Quarter + "\n" + "Dime " + Dime + "\n" +
                "Nickel " + Nickel + "\n" + "Penny " + Penny); 
        }
    }
}
