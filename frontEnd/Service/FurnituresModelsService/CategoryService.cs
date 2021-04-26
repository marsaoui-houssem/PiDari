using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using Model.FurnituresModels;

namespace Service.FurnituresModelsService
{
    public class CategoryService
    {
        HttpClient httpClient;
        public CategoryService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        public Boolean Add(Category category)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Category>(Statics.baseAddress + "dari/furnitures/addCategory",
                    category).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public Category getCategoryById(long id)
        {
            Category Category = null;
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getCategoryById/" + id).Result;
            if (response.IsSuccessStatusCode)
            {
                var category = response.Content.ReadAsAsync<Category>().Result;
                return category;
            }
            return Category;
        }

        public bool Update(long id, Category category)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Category>(Statics.baseAddress + "dari/furnitures/modifierCategory/" + id, category).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }
        public bool deleteCategoryById(long id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "dari/furnitures/deleteCategory/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public IEnumerable<Category> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllCategory").Result;
            if (response.IsSuccessStatusCode)
            {
                var category = response.Content.ReadAsAsync<IEnumerable<Category>>().Result;
                return category;
            }
            return new List<Category>();
        }
    }
}
