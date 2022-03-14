# PDFPicker
This pdf picker support all android versions including Android 11 and 12 <br>
-This project uses default "ActivityResultContract" api to pick pdf file.This api open a default file picker with only PDF files enabled to choose from. <br>
-I have included example for both Kotlin and Java

Code snipit for kotlin : <Br>
  
  Register for result : <Br>
  
   var resultPdf  = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.tvPickedFileUri.text = it?.let {
                ""+it.path
            }
        }

  On file pick action : <Br>
  
  binding.btnPickPdf.setOnClickListener {
            //"application/pdf" is mime type for pdf you can add different mime types for picking different kind of files
            //e.g image/*
            resultPdf.launch("application/pdf")
        }
