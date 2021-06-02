using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Week2_WebForm
{
    public partial class WebForm4 : System.Web.UI.Page
    {//Author Minh PHuong Ly C0757038
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {        
            int amount = Convert.ToInt32(Amount.Text);
            double ownedTax = Convert.ToDouble(Percentage.Text) *amount / 100;
            double total1 = amount - ownedTax;
            Label4.Text = "Your owned tax amount:  " + ownedTax.ToString("#.##");
            Label3.Text = "Your total wage is: "+amount;
            total.Text = "Your net total is: " + total1.ToString("#.##");
                
        }
    }
}