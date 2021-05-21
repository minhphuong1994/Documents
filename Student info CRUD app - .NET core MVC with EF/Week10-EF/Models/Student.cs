using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

#nullable disable

namespace Week10_EF.Models
{
    public partial class Student
    {
        [Required]
        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public string UserPassword { get; set; }
        public int? GradeId { get; set; }

        public virtual Grade Grade { get; set; }
    }
}
