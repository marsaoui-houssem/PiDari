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
    public class CommandService
    {
        HttpClient httpClient;
        public CommandService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public Boolean Add(Command command)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Command>(Statics.baseAddress + "dari/furnitures/addFurniture", command).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public Command getCommandById(long commandId)
        {
            Command command = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getFurnitureById/" + commandId).Result;

            if (response.IsSuccessStatusCode)
            {
                var b
                    = response.Content.ReadAsAsync<Command>().Result;

                return b;
            }


            return command;
        }


        public bool Update(long id, Command command)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Command>(Statics.baseAddress + "dari/furnitures/modifierFurniture/" + id, command).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool deleteCommandById(long id)
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

        public IEnumerable<Command> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllCFurniture").Result;
            if (response.IsSuccessStatusCode)
            {
                var commands = response.Content.ReadAsAsync<IEnumerable<Command>>().Result;
                return commands;
            }
            return new List<Command>();
        }
    }
}
