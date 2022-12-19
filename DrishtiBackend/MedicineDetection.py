# GitHub repo installation of paddle
import PaddleOCR
import cv2
import plt
import os

ocr_model = PaddleOCR(lang='en')
img_path='Drishti\DrishtiApp\Medicine Detection\\testimg.png'
result = ocr_model.ocr(img_path)
result
for res in result:
    print(res[1][0]) 

boxes = [res[0] for res in result] # 
texts = [res[1][0] for res in result]
scores = [res[1][1] for res in result]    
font_path = os.path.join('PaddleOCR', 'doc', 'fonts', 'latin.ttf')
img = cv2.imread(img_path) 
img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB) 
plt.figure(figsize=(15,15))
annotated = draw_ocr(img, boxes, texts, scores, font_path=font_path) 
plt.imshow(annotated) 
img.shape