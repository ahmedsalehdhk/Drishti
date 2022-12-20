# This program prints Hello, world!
import app
import ObjectDetection

# mode= app.img
def testing(mode, img):
    if mode=="0":
        class_text="not working"
    elif mode=="1":
        if img=="1":
            class_text=ObjectDetection.result
    elif mode=="2":
        class_text="Working 2 and 0"
    elif mode=="3":
        class_text="Working 3 and 0"
    elif mode=="4":
        class_text="Working 4 and 0"
    else:
        class_text="Working not right"

    return class_text

# print('Hello, world!')