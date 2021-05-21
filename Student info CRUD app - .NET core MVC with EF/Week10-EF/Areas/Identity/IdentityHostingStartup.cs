using System;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.UI;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Week10_EF.Areas.Identity.Data;
using Week10_EF.Data;

[assembly: HostingStartup(typeof(Week10_EF.Areas.Identity.IdentityHostingStartup))]
namespace Week10_EF.Areas.Identity
{
    public class IdentityHostingStartup : IHostingStartup
    {
        public void Configure(IWebHostBuilder builder)
        {
            builder.ConfigureServices((context, services) => {
                services.AddDbContext<Week10_EFContext>(options =>
                    options.UseSqlServer(
                        context.Configuration.GetConnectionString("Week10_EFContextConnection")));

                services.AddDefaultIdentity<Week10_EFUser>(options => options.SignIn.RequireConfirmedAccount = true)
                    .AddEntityFrameworkStores<Week10_EFContext>();
            });
        }
    }
}