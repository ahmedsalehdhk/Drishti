


from paddleocr import PaddleOCR, draw_ocr # main OCR dependencies
from matplotlib import pyplot as plt # plot images
import cv2 #opencv
import os # folder directory navigation

"""# 2. Instantiate Model and Detect"""

# Setup model
ocr_model = PaddleOCR(lang='en')
img_path='/Users/tanajjahamed/Downloads/aid10634308-v4-1200px-Write-Book-Titles-in-MLA-Step-14.jpg'

# Run the ocr method on the ocr model
result = ocr_model.ocr(img_path)

result

for res in result:
    print(res[1][0])

