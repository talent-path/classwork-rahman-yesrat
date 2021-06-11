﻿using System;
namespace VendingMachine.Models
{
    public class Candy
    {

        public string Name { get; }
        public int Quantity { get; set; }
        public decimal Price { get; }

        public Candy()
        {
        }

        public Candy(string name, int quantity, decimal price)
        {
            Name = name;
            Quantity = quantity;
            Price = price;
        }
    }
}