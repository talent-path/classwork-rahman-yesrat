﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

using SpringFoodBackend.Interfaces;
using SpringFoodBackend.Models.Domain;

namespace SpringFoodBackend.Repos
{
    public class CategoryRepo : ICategory
    {
        private SpringFoodDbContext _context;

        public CategoryRepo(SpringFoodDbContext context)
        {
            _context = context;
        }
        public int AddCategory(Category toAdd)
        {

            _context.Categories.Add(toAdd);
            _context.SaveChanges();
            return toAdd.Id;
        }

        public List<Category> GetAllCategories()
        {
            return _context.Categories.Include(category => category.Products).ToList() ; 
        }

        public List<Product> GetProductByCatId(int id)
        {
            
            List<Product> products = _context.Products.Where(x => x.CategoryId == id).ToList();

            Category toCat = _context.Categories.Find(id);
            _context.Attach(toCat);



            return products;
        }
    }
}