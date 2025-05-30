sudo rm /usr/bin/chromedriver

wget https://chromedriver.storage.googleapis.com/112.0.5615.49/chromedriver_linux64.zip
unzip chromedriver_linux64.zip

sudo mv chromedriver-linux64/chromedriver /usr/bin/chromedriver
sudo chmod +x /usr/bin/chromedriver

sudo rm LICENSE.chromedriver
sudo rm chromedriver_linux64.zip

chromedriver --version