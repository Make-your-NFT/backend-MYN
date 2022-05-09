package org.project.myn.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"seller_account", "winner_account", "from_account", "to_account", "collection"})
public class NftSales extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 판매종료시간
    private LocalDateTime time;

    // 경매유형
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Auction> auctionSet = new HashSet<>();

    // 스마트계약서주소
    private String contract_address;

    // NFT 판매수량
    private Long quantity;

    // 결제기호
    private String payment_symbol;

    // NFT 지불가격
    private Double total_price;

    // 판매자계정
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts seller_account;

    // 구매자 계정
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts winner_account;

    // Transfer_from
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts from_account;

    // Transfer_to
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts to_account;

    // 컬렉션 ID
    @ManyToOne(fetch = FetchType.LAZY)
    private Collections collection;

}
