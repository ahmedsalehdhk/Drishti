import cv2
from PIL import Image

# OpenCV DNN
net = cv2.dnn.readNet("dnn_model/yolov4-tiny.weights", "dnn_model/yolov4-tiny.cfg")
model = cv2.dnn_DetectionModel(net)
model.setInputParams(size=(416,416), scale=1/255)

# Load class lists
classes = []
with open("dnn_model/classes.txt", "r") as file_object:
    for class_name in file_object.readlines():
        class_name = class_name.strip()
        classes.append(class_name)

img = cv2.imread("test.jpeg")

# Object Detection
(class_ids, scores, bboxes) = model.detect(img)
for class_id, score, bbox in zip(class_ids, scores, bboxes):
    (x, y, w, h) = bbox
    class_name = classes[class_id]
    cv2.putText(img, str(class_name), (x, y-10), cv2.QT_FONT_NORMAL, 1, (0,255,255), 1)
    cv2.rectangle(img, (x, y), (x+w, y+h), (0,255,0), 3)

cv2.imshow("Output", img)
cv2.waitKey(0)

