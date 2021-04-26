using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Model.FurnituresModels;
using frontEnd.Data;
using Service.FurnituresModelsService;

namespace frontEnd.Controllers.FurnituresModelsController
{
    public class CategoriesController : Controller
    {
        
        CategoryService categoryService = new CategoryService();
        // GET: Categories
        public ActionResult Index()
        {
            return View(categoryService.GetAll());
        }

        // GET: Categories/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Category category = categoryService.getCategoryById(id);
            if (category == null)
            {
                return HttpNotFound();
            }
            return View(category);
        }

        // GET: Categories/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Categories/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        public ActionResult Create([Bind(Include = "Name,Description")] Category category)
        {
            if (categoryService.Add(category))
            {
                return RedirectToAction("Index");
            }

            return View();
        }

        // GET: Categories/Edit/5
        public ActionResult Edit(long id)
        {
            return View();
        }

        // POST: Categories/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        public ActionResult Edit(long id ,[Bind(Include = "CategoryId,Name,Description")] Category category)
        {
            if (categoryService.Update(id,category))
            {
                return RedirectToAction("Index");
            }
            return View();
        }

        // GET: Categories/Delete/5
        public ActionResult Delete()
        {
            return View();
        }

        // POST: Categories/Delete/5
        [HttpPost]
        public ActionResult Delete(long id)
        {
            if(categoryService.deleteCategoryById(id))
            {
                return RedirectToAction("Index");
            }
            return View();
            
        }
    }
}
