<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="TaxCal.aspx.cs" Inherits="Week2_WebForm.WebForm4" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h1>Tax Calculator</h1>
    <asp:Image ID="Image1" runat="server" ImageAlign="NotSet" ImageUrl="~/img/img.jpg" Height="130" Width="450" /><br />
    <asp:Label ID="Label1" runat="server" Text="Tax Percentage"></asp:Label>
    <asp:TextBox ID="Percentage" runat="server"></asp:TextBox><br />
    <asp:Label ID="Label2" runat="server" Text="Tax Amount"></asp:Label>
    <asp:TextBox ID="Amount" runat="server"></asp:TextBox><br />    
    <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" /><br />
    
    <asp:Label ID="Label3" runat="server" Text=""></asp:Label><br />
    <asp:Label ID="Label4" runat="server" Text=""></asp:Label><br />
    <asp:Label ID="total" runat="server" Text=""></asp:Label>
</asp:Content>
