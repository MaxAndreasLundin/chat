async function postData(url = "", data = {}) {
  const response = await fetch(url, {
    method: "POST",
    mode: "cors",
    cache: "no-cache",
    credentials: "same-origin",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    referrerPolicy: "no-referrer",
    body: JSON.stringify(data),
  });
  return response.json();
}

function clearMessages() {
  const chat = document.getElementById("chats");
  chat.innerHTML = "";
}

function addMessage(messageText) {
  const chat = document.getElementById("chats");
  const message1 = document.createElement("div");
  const textNode = document.createTextNode(messageText);
  message1.classList.add("client-chat");
  message1.appendChild(textNode);
  chat.appendChild(message1);
}

function updateMessages() {
  fetch("http://localhost:8080/api/v1/messages")
    .then((response) => response.json())
    .then((messages) => {
      clearMessages();
      messages.forEach((message) => {
        addMessage(message.text);
      });
    });
}

function postMessage(messageText) {
  const postMessageDto = {
    userId: "11",
    text: messageText,
  };

  postData("http://localhost:8080/api/v1/messages", postMessageDto);
}

function sendMessage() {
  const input = document.getElementById("messageTextInput");
  const messageText = input.value;
  input.value = "";
  postMessage(messageText);
}

updateMessages();
setInterval(updateMessages, 1000);
