import * as S from './style';

type UserImgProps = {
  img: string;
  size: 'small' | 'medium';
  alt?: string;
};

function UserImg({ img, size, alt }: UserImgProps) {
  return (
    <S.Container size={size}>
      <S.Img src={img} size={size} alt={alt} />
    </S.Container>
  );
}

export default UserImg;
