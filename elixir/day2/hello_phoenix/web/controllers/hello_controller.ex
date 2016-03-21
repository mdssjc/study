defmodule HelloPhoenix.HelloController do
  use HelloPhoenix.Web, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end

  def show(conn, %{"messeger" => messeger}) do
    render conn, "show.html", messeger: messeger
  end
end
