using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

#nullable disable

namespace MinhPhuongLyC0757038Assignment2.Models
{
    public partial class Employee
    {
        public int EmployeeId { get; set; }
        [Required, MinLength(2)]
        public string FirstName { get; set; }
        [Required, MinLength(2)]
        public string LastName { get; set; }
        [Required, DataType(DataType.EmailAddress)]
        public string Email { get; set; }
        [Required, DataType(DataType.PhoneNumber)]
        public string PhoneNumber { get; set; }
        [Required, DataType(DataType.Date)]
        public DateTime HireDate { get; set; }
        [Required, DataType(DataType.Currency)]
        public decimal Salary { get; set; }
        [Required]
        public int? DepartmentId { get; set; }

        public virtual Department Department { get; set; }
    }
}
