using Model.FurnituresModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Service.FurnituresModelsService
{
    public class FurnitureService
    {
        HttpClient httpClient;
        public FurnitureService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public Boolean Add(Furniture furniture)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Furniture>(Statics.baseAddress + "dari/furnitures/addFurniture", furniture).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public Furniture getFurnitureById(long furnitureId)
        {
            Furniture furniture = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getFurnitureById/" + furnitureId).Result;

            if (response.IsSuccessStatusCode)
            {
                var b
                    = response.Content.ReadAsAsync<Furniture>().Result;

                return b;
            }


            return furniture;
        }
        public bool Update(long id, Furniture furniture)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Furniture>(Statics.baseAddress + "dari/furnitures/modifierFurniture/" + id, furniture).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool deleteFurnitureById(long id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "dari/furnitures/deleteFurniture/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public IEnumerable<Furniture> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllCFurniture").Result;
            if (response.IsSuccessStatusCode)
            {
                var furnitures = response.Content.ReadAsAsync<IEnumerable<Furniture>>().Result;
                return furnitures;
            }
            return new List<Furniture>();
        }




    }
}
