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
    public class BasketService
    {
        HttpClient httpClient;
        public BasketService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public Boolean Add(long userId, long furnitureId , int quantity)
        {
            try
            {
                var APIResponse = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/addBasket/"+quantity+"/"+userId+"/"+furnitureId);
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public Basket getBasketById(long basketId)
        {
            Basket basket = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getBasketById/" + basketId).Result;

            if (response.IsSuccessStatusCode)
            {
                var b
                    = response.Content.ReadAsAsync<Basket>().Result;

                return b;
            }


            return basket;
        }


        public bool Update(long id, Basket basket)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Basket>(Statics.baseAddress + "dari/furnitures/modifierBasket/" + id, basket).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool deleteBasketById(long id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "dari/furnitures/deleteBasket/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public IEnumerable<Basket> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllBasket").Result;
            if (response.IsSuccessStatusCode)
            {
                var baskets = response.Content.ReadAsAsync<IEnumerable<Basket>>().Result;
                return baskets;
            }
            return new List<Basket>();
        }
    }
}
