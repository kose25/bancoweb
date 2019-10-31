/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
 
 	$('#dropdown').change(function() {
  	if( $(this).val() == 3) {
       		$('#origen').prop( "enabled", true );
    } else {       
      $('#origen').prop( "disabled", true );
    }
  });
 
});
