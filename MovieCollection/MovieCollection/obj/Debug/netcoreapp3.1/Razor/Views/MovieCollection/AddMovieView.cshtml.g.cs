#pragma checksum "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "8e1b103350442fd6cca3c59c02b9634d30eb0b60"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_MovieCollection_AddMovieView), @"mvc.1.0.view", @"/Views/MovieCollection/AddMovieView.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/_ViewImports.cshtml"
using MovieCollection;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/_ViewImports.cshtml"
using MovieCollection.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"8e1b103350442fd6cca3c59c02b9634d30eb0b60", @"/Views/MovieCollection/AddMovieView.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"4193ac9fc819843aae276788a0fb0c9029300161", @"/Views/_ViewImports.cshtml")]
    public class Views_MovieCollection_AddMovieView : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<MovieModel>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 4 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
 using (Html.BeginForm(FormMethod.Post, "AddMovieView"))
{

    

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.HiddenFor(m => m.Id));

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                              ;

    

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.LabelFor(m => m.Title));

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                                ;
    

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.TextBoxFor(m => m.Title));

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                                  ;

    

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.LabelFor(m => m.Director));

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                                   ;
    

#line default
#line hidden
#nullable disable
#nullable restore
#line 13 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.TextBoxFor(m => m.Director));

#line default
#line hidden
#nullable disable
#nullable restore
#line 13 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                                     ;

    

#line default
#line hidden
#nullable disable
#nullable restore
#line 15 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.LabelFor(m => m.Year));

#line default
#line hidden
#nullable disable
#nullable restore
#line 15 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                               ;
    

#line default
#line hidden
#nullable disable
#nullable restore
#line 16 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
Write(Html.TextBoxFor(m => m.Year));

#line default
#line hidden
#nullable disable
#nullable restore
#line 16 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"
                                 ;


#line default
#line hidden
#nullable disable
            WriteLiteral("    <button> Click Me! </button>\n");
#nullable restore
#line 19 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/MovieCollection/MovieCollection/Views/MovieCollection/AddMovieView.cshtml"

}

#line default
#line hidden
#nullable disable
            WriteLiteral("\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<MovieModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
