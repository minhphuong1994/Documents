using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

#nullable disable

namespace Week10_EF.Models
{
    public partial class Grade
    {
        public Grade()
        {
            Students = new HashSet<Student>();
        }
        [Required]
        public int GradeId { get; set; }
        public int? Grade1 { get; set; }
        public string SubjectId { get; set; }

        public virtual ICollection<Student> Students { get; set; }
    }
}
