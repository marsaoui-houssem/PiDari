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
    public class GiftPointsService
    {
        HttpClient httpClient;
        public GiftPointsService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }


        public Boolean Add(GiftPoints giftPoints)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<GiftPoints>(Statics.baseAddress + "dari/furnitures/addFurniture", giftPoints).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public GiftPoints getGiftPointsById(long giftPointsId)
        {
            GiftPoints giftPoints = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getFurnitureById/" + giftPointsId).Result;

            if (response.IsSuccessStatusCode)
            {
                var b
                    = response.Content.ReadAsAsync<GiftPoints>().Result;

                return b;
            }


            return giftPoints;
        }


        public bool Update(long id, GiftPoints giftPoints)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<GiftPoints>(Statics.baseAddress + "dari/furnitures/modifierFurniture/" + id, giftPoints).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public bool deleteGiftPointsById(long id)
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


        public IEnumerable<GiftPoints> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllCFurniture").Result;
            if (response.IsSuccessStatusCode)
            {
                var giftPoints = response.Content.ReadAsAsync<IEnumerable<GiftPoints>>().Result;
                return giftPoints;
            }
            return new List<GiftPoints>();
        }
    }
}
