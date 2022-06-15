interface props {
  content: string;
  msg: string;
}

function Title({ content, msg }: props) {
  return (
    <h1>
      {content} {msg}
    </h1>
  );
}

export default Title;
