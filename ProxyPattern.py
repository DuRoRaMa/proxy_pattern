class Image:
    def display(self):
        pass

class RealImage(Image):
    def __init__(self, filename):
        self.filename = filename
        self._load_image()

    def _load_image(self):
        print(f"Загрузка {self.filename}...")

    def display(self):
        print(f"Отображение {self.filename}")

class ProxyImage(Image):
    def __init__(self, filename):
        self.filename = filename
        self.real_image = None

    def display(self):
        if not self.real_image:
            self.real_image = RealImage(self.filename)
        self.real_image.display()

# Использование
image1 = ProxyImage("photo1.jpg")
image2 = ProxyImage("photo2.jpg")

image1.display()  # Загружает и отображает photo1.jpg
