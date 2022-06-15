import * as S from './style';

interface props {
  content: string;
  msg: string;
}

function Title({ content, msg }: props) {
  return (
    <>
      <S.Title>
        {content} {msg}
      </S.Title>
      <S.SubTitle>
        {content} {msg}
      </S.SubTitle>
    </>
  );
}

export default Title;
